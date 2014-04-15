/*******************************************************************************
 * Copyright (c) 2011-2014 Alexander Kerner. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sf.bioutils.proteomics;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFile;
import net.sf.jfasta.FASTAFileReader;
import net.sf.jfasta.impl.FASTAElementIterator;
import net.sf.jfasta.impl.FASTAFileReaderImpl;
import net.sf.jfasta.impl.HeaderDialectUniprot;
import net.sf.kerner.utils.Cache;
import net.sf.kerner.utils.collections.UtilCollection;
import net.sf.kerner.utils.collections.list.impl.UtilList;
import net.sf.kerner.utils.log.LogOnlyOnce;
import net.sf.kerner.utils.pair.KeyValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeptideSearcher {

    public static enum DatabaseID {
        ACCESSION, PROTEIN, GENE, SPECIES
    }

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

    private final LogOnlyOnce logo = new LogOnlyOnce(log);

    public final static int DEFAULT_CACHE_SIZE = 1000;

    private final static Logger log = LoggerFactory.getLogger(PeptideSearcher.class);

    private final static HeaderDialectUniprot HEADERD_DIALECT_UNIPROT = new HeaderDialectUniprot();

    public static boolean areSameByID(final Collection<String> headers, final DatabaseID databaseID) {
        boolean result = true;
        String idOld = null;
        for (final String header : headers) {
            HEADERD_DIALECT_UNIPROT.setHeaderString(header);
            final String id = getIDStringFromHeader(header, databaseID);
            if (idOld == null || idOld.equals(id)) {
                idOld = id;
            } else if (idOld != null && !idOld.equals(id)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static String getIDStringFromHeader(final String fastaHeader,
            final DatabaseID databaseId) {
        HEADERD_DIALECT_UNIPROT.setHeaderString(fastaHeader);
        switch (databaseId) {
            case ACCESSION:
                return HEADERD_DIALECT_UNIPROT.getAccessionNumber();
            case GENE:
                return HEADERD_DIALECT_UNIPROT.getGeneName();
            case PROTEIN:
                return HEADERD_DIALECT_UNIPROT.getProteinName();
            case SPECIES:
                return HEADERD_DIALECT_UNIPROT.getSpeciesName();
            default:
                throw new RuntimeException("Unkown ID " + databaseId);
        }
    }

    private static List<String> getList(final FASTAElementIterator it, final String seq)
            throws IOException {
        final List<String> result = UtilList.newList();
        while (it.hasNext()) {
            final FASTAElement nextElement = it.next();
            if (nextElement.getSequence().contains(seq)) {
                result.add(nextElement.getHeader());
            }
        }
        return result;
    }

    private static List<String> getList(final Iterator<FASTAElement> it, final String seq)
            throws IOException {
        final List<String> result = UtilList.newList();
        while (it.hasNext()) {
            final FASTAElement nextElement = it.next();
            if (nextElement.getSequence().contains(seq)) {
                result.add(nextElement.getHeader());
            }
        }
        return result;
    }

    private int cacheSize = DEFAULT_CACHE_SIZE;

    private Cache<String, List<String>> cache;

    private final DatabaseID databaseId;

    private final boolean speciesSpec;

    private boolean cacheFASTAFile = false;

    private final Map<File, FASTAFile> cacheFASTAFileMap;

    public PeptideSearcher(final DatabaseID databaseId, final boolean speciesSpec) {
        cache = new Cache<String, List<String>>(getCacheSize());
        this.databaseId = databaseId;
        this.speciesSpec = speciesSpec;
        cacheFASTAFileMap = new HashMap<File, FASTAFile>();
    }

    // private synchronized String getIDStringFromHeader(final String
    // fastaHeader) {
    // return getIDStringFromHeader(fastaHeader, databaseId);
    // }

    public PeptideSearcher(final DatabaseID databaseId, final boolean speciesSpec,
            final Cache<String, List<String>> cache, final Map<File, FASTAFile> cacheFASTAFileMap) {
        this.cache = cache;
        this.databaseId = databaseId;
        this.speciesSpec = speciesSpec;
        this.cacheFASTAFileMap = cacheFASTAFileMap;
        if (log.isInfoEnabled()) {
            log.info("Initiated with given cache (capacity of " + cache.getCapacity()
                    + ", size of " + cache.getSize() + ", hash " + cache.hashCode() + ")");
        }
    }

    public synchronized boolean areSameByID(final Collection<String> headers) {
        return areSameByID(headers, databaseId);
    }

    public synchronized int getCacheSize() {
        return cacheSize;
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
    public synchronized List<String> getFromDBFile(final File db, final String seq)
            throws IOException {
        List<String> result = cache.get(seq);
        if (result != null) {
            // System.err.println("got from seq cache");
            return result;
        }
        if (isCacheFASTAFile()) {
            FASTAFile file;
            synchronized (cacheFASTAFileMap) {
                file = cacheFASTAFileMap.get(db);
                if (file == null) {
                    if (log.isDebugEnabled()) {
                        log.debug("read from file");
                    }
                    file = new FASTAFileReaderImpl(db).read();
                    if (log.isDebugEnabled()) {
                        log.debug("done reading");
                    }
                    cacheFASTAFileMap.put(db, file);
                    if (log.isDebugEnabled()) {
                        log.debug("write to cache");
                    }
                } else {
                    if (log.isDebugEnabled()) {
                        logo.debug("got from cache");
                    }
                }
            }
            result = getList(file.iterator(), seq);
        } else {
            final FASTAFileReader fastaReader = new FASTAFileReaderImpl(db);
            final FASTAElementIterator it = fastaReader.getIterator();
            result = getList(it, seq);
            fastaReader.close();
        }
        cache.put(seq, result);
        return result;
    }

    public synchronized Result getResult(final List<String> headers, final boolean redundant,
            final boolean speciesSpec) {
        if (UtilCollection.nullOrEmpty(headers)) {
            return new Result();
        }
        if (headers.size() == 1) {
            return Result.buildProteotypic(headers);
        } else {

            if (redundant && speciesSpec) {
                final boolean sameSpec = areSameByID(headers, DatabaseID.SPECIES);
                final boolean sameProt = areSameByID(headers, DatabaseID.PROTEIN);
                final boolean sameGene = areSameByID(headers, DatabaseID.GENE);
                if (sameSpec && (sameProt || sameGene)) {
                    return Result.buildProteotypic(headers);
                } else {
                    return Result.buildDegen(headers);
                }
            }

            final boolean areSameByID = areSameByID(headers);
            if (areSameByID) {
                return Result.buildDegen(headers);
            } else {
                return Result.buildProteotypic(headers);
            }
        }
    }

    public synchronized boolean isCacheFASTAFile() {
        return cacheFASTAFile;
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
     *
     */
    public synchronized Result reduceToProteotipic(final String seq,
            final List<? extends KeyValue<File, Boolean>> dbs) throws IOException {
        Result result = new Result();
        for (final KeyValue<File, Boolean> db : dbs) {
            final List<String> headers = getFromDBFile(db.getFirst(), seq);
            result = getResult(headers, db.getSecond(), speciesSpec);
            if (result.type.equals(Result.Type.NOT_FOUND)) {
                // continue other DBs
            } else {
                return result;
            }
        }
        return result;
    }

    public synchronized void setCacheFASTAFile(final boolean cacheFASTAFile) {
        this.cacheFASTAFile = cacheFASTAFile;
    }

    public synchronized void setCacheSize(final int cacheSize) {
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
