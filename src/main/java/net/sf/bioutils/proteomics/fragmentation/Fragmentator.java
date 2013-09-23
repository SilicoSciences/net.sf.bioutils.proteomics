package net.sf.bioutils.proteomics.fragmentation;

import java.util.List;

import net.sf.bioutils.proteomics.peptides.Peptide;

public interface Fragmentator {

    List<Peptide> fractionate(final Peptide peptide);

}