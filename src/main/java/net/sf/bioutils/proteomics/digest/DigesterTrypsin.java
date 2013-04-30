package net.sf.bioutils.proteomics.digest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import net.sf.bioutils.proteomics.Peptide;
import net.sf.bioutils.proteomics.PeptideSequence;
import net.sf.bioutils.proteomics.impl.PeptideSequenceChargedSingle;
import net.sf.jranges.range.integer.impl.DummyIntegerRange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigesterTrypsin implements Digester {

    private final static Logger log = LoggerFactory.getLogger(DigesterTrypsin.class);

    private void addToResult(final Collection<PeptideSequence> result, final PeptideSequence peptides,
            final int indexLow, final int indexHigh) {
        // TODO: use factory
        if (indexLow < indexHigh && indexHigh <= peptides.asList().size()) {
            final PeptideSequenceChargedSingle seq = new PeptideSequenceChargedSingle(peptides.asList().subList(
                    indexLow, indexHigh));
            seq.setModifications(peptides.getModifications());
            result.add(seq);
        } else {
            if (log.isDebugEnabled()) {
                log.debug("skip invalid range " + new DummyIntegerRange(indexLow, indexHigh));
            }
        }
    }

    public List<PeptideSequence> digest(final PeptideSequence peptides, final int numMissCleav) {

        final Set<PeptideSequence> result = new LinkedHashSet<PeptideSequence>();
        final SortedSet<Integer> cleavSites = getCleavageSites(peptides);
        for (int i = 0; i <= numMissCleav; i++) {
            int lastOne = 0;
            final Iterator<Integer> it = cleavSites.iterator();
            while (it.hasNext()) {
                final Integer next = it.next();
                addToResult(result, peptides, lastOne, getMissCleavIndex(next, i, cleavSites) + 1);
                lastOne = next + 1;
            }
            addToResult(result, peptides, lastOne, peptides.asList().size());
        }

        return new ArrayList<PeptideSequence>(result);
    }

    public SortedSet<Integer> getCleavageSites(final PeptideSequence peptides) {
        final TreeSet<Integer> result = new TreeSet<Integer>();

        // last index
        result.add(peptides.asList().size() - 1);

        for (int i = 0; i < peptides.asList().size(); i++) {
            final Peptide nextP = peptides.asList().get(i);
            Peptide next2P = null;
            if (peptides.asList().size() > i + 1) {
                next2P = peptides.asList().get(i + 1);
            }
            if ((nextP.equals(Peptide.R) || nextP.equals(Peptide.K)) && ((next2P == null || !next2P.equals(Peptide.P)))) {
                result.add(i);
            }
        }
        return result;
    }

    private int getMissCleavIndex(final int currentIndex, final int numMissCLeav, final SortedSet<Integer> cleavSites) {
        final List<Integer> copy = new ArrayList<Integer>(cleavSites);
        final int indexOf = copy.indexOf(currentIndex);
        if (copy.size() > indexOf + numMissCLeav) {
            return copy.get(indexOf + numMissCLeav);
        } else {
            if (log.isDebugEnabled()) {
                log.debug("skip invalid miss cleav index " + indexOf + numMissCLeav);
            }
            return currentIndex;
        }
    }
}
