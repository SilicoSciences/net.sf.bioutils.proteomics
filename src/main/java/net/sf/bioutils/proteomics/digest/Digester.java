package net.sf.bioutils.proteomics.digest;

import java.util.List;

import net.sf.bioutils.proteomics.PeptideSequence;

public interface Digester {

    List<PeptideSequence> digest(final PeptideSequence peptides, final int numMissCleav);

}
