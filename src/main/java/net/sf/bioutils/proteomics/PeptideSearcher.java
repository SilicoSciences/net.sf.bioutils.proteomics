package net.sf.bioutils.proteomics;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFile;
import net.sf.jfasta.FASTAFileReader;
import net.sf.jfasta.impl.FASTAElementIterator;
import net.sf.jfasta.impl.FASTAFileReaderImpl;
import net.sf.jfasta.impl.HeaderDialectUniprot;
import net.sf.kerner.utils.Cache;
import net.sf.kerner.utils.collections.UtilCollection;
import net.sf.kerner.utils.collections.list.impl.UtilList;
import net.sf.kerner.utils.pair.KeyValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeptideSearcher {

    public static class Result {
        public static enum Type {
            DEGEN, PROTEOTYYPIC, NOT_FOUND
        }

        public static Result buildDegen(final List<String> headers) {
            final Result r = new Result();
            r.headers = headers;
            r.type = Result.Type.DEGEN;
            return r;
        }

        public static Result buildNotFound() {
            final Result r = new Result();
            r.headers = Collections.emptyList();
            r.type = Result.Type.NOT_FOUND;
            return r;
        }

        public static Result buildProteotypic(final List<String> headers) {
            final Result r = new Result();
            r.headers = headers;
            r.type = Result.Type.PROTEOTYYPIC;
            return r;
        }

        public List<String> headers = Collections.emptyList();
        public Type type = Type.NOT_FOUND;

        @Override
        public String toString() {
            return type.toString();
        }
    }

    // private final static Logger log =
    // LoggerFactory.getLogger(PeptideSearcher.class);

    public final static int DEFAULT_CACHE_SIZE = 100;

    /**
     * Checks given {@link Collection} of {@link FASTAElement#getHeader() FASTA
     * headers} if they all have the same gene name.
     * 
     * @param id
     *            {@link Collection} of {@link FASTAElement#getHeader() FASTA
     *            headers} to check
     * @return {@code true}, if all given headers have the same gene name or no
     *         gene name, {@code false} otherwise
     */
    public static boolean fromSameGene(final Collection<String> id) {
        boolean result = true;
        final HeaderDialectUniprot hd = new HeaderDialectUniprot();
        String geneName = null;
        for (final String header : id) {
            hd.setHeaderString(header);
            final String geneNameNew = hd.getGeneName();
            if (geneName == null || geneName.equals(geneNameNew)) {
                geneName = geneNameNew;
            } else if (geneName != null && !geneName.equals(geneNameNew)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Returns all {@link FASTAElement#getHeader() FASTA headers} from all
     * {@link FASTAElement elements} which contain given sequence string.
     * 
     * @param db
     *            FASTA file to read
     * @param seq
     *            Sequence string to match
     * @return A {@link List} containing all matching
     *         {@link FASTAElement#getHeader() FASTA headers}
     * @throws IOException
     *             if reading fails
     */
    public static List<String> getFromDBFile(final File db, final String seq) throws IOException {
        final List<String> result = UtilList.newList();
        final FASTAFileReader fastaReader = new FASTAFileReaderImpl(db);
        final FASTAElementIterator it = fastaReader.getIterator();
        while (it.hasNext()) {
            final FASTAElement nextElement = it.next();
            if (nextElement.getSequence().contains(seq)) {
                result.add(nextElement.getHeader());
            }
        }
        fastaReader.close();
        return result;
    }

    /**
     * 
     * @param seq
     *            a peptide sequence
     * @param headers
     *            a {@link List} of {@link FASTAElement#getHeader() FASTA
     *            headers}
     * @param iso
     *            {@code true} if {@code headers} comes from a database that
     *            contains isoforms; {@code false} otherwise
     */
    public static Result getResult(final List<String> headers, final boolean iso) {
        if (UtilCollection.nullOrEmpty(headers)) {
            return new Result();
        }
        if (headers.size() == 1) {

            return Result.buildProteotypic(headers);
        } else {
            if (iso) {
                // if iso, check if all gene names are same. if yes,
                // proteotipic.
                final boolean sameGene = fromSameGene(headers);
                if (sameGene) {
                    return Result.buildProteotypic(headers);
                } else {
                    return Result.buildDegen(headers);
                }
            } else {
                return Result.buildDegen(headers);
            }
        }
    }

    private int cacheSize = DEFAULT_CACHE_SIZE;

    private FASTAFile cacheFastaFile = null;

    private Cache<String, List<String>> cache;

    private final static Logger log = LoggerFactory.getLogger(PeptideSearcher.class);

    public PeptideSearcher() {
        cache = new Cache<String, List<String>>(getCacheSize());
    }

    public PeptideSearcher(final Cache<String, List<String>> cache) {
        this.cache = cache;
        if (log.isInfoEnabled()) {
            log.info("Initiated with given cache (capacity of " + cache.getCapacity() + ", hash "
                    + cache.hashCode() + ")");
        }
    }

    public int getCacheSize() {
        return cacheSize;
    }

    /**
     * 
     * @param db
     *            FASTA file to read
     * @param seq
     *            Sequence string to match
     * @return a {@link List} of {@link FASTAElement#getHeader() FASTA headers},
     *         which sequence contains given sequence
     * @throws IOException
     *             if reading fails
     */
    public List<String> getFromDBMemory(final File db, final String seq) throws IOException {
        final List<String> cacheResult = cache.get(seq);
        if (cacheResult != null) {
            return cacheResult;
        }
        if (cacheFastaFile == null) {
            final FASTAFileReader fastaReader = new FASTAFileReaderImpl(db);
            cacheFastaFile = fastaReader.read();
        }
        final List<String> result = UtilList.newList();
        for (final FASTAElement fe : cacheFastaFile) {
            if (fe.getSequence().contains(seq)) {
                result.add(fe.getHeader());
            }
        }
        cache.put(seq, result);
        return result;
    }

    /**
     * Checks if given peptide sequence can be found prototypically any one of
     * given databases.
     * 
     * @param seq
     *            peptide sequence string
     * @param dbs
     *            a {@link List} of databases which are searched one after
     *            another for given {@code seq}
     * @throws IOException
     *             if file reading fails
     * 
     * @see {@link #reduceToProteotipic(String, KeyValue)}
     */
    public Result reduceToProteotipic(final String seq,
            final List<? extends KeyValue<File, Boolean>> dbs) throws IOException {
        Result result = new Result();
        for (final KeyValue<File, Boolean> db : dbs) {
            final List<String> headers = getFromDBMemory(db.getFirst(), seq);
            result = getResult(headers, db.getSecond());
            if (result.type.equals(Result.Type.NOT_FOUND)) {
                // continue other DBs
            } else {
                return result;
            }
        }
        return result;
    }

    public void setCacheSize(final int cacheSize) {
        if (this.cacheSize == cacheSize) {
            return;
        }
        this.cacheSize = cacheSize;
        cache = new Cache<String, List<String>>(cacheSize);
        if (log.isInfoEnabled()) {
            log.info("Cache size changed to " + cacheSize + ", reinit cache");
        }
    }
}
