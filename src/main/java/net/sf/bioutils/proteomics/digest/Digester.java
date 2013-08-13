package net.sf.bioutils.proteomics.digest;

import java.util.List;

import net.sf.bioutils.proteomics.peptides.Peptide;

public interface Digester {

    List<Peptide> digest(final Peptide peptides, final int numMissCleav);

}
