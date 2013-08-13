package net.sf.bioutils.proteomics.fractionation;

import java.util.List;

import net.sf.bioutils.proteomics.peptides.Peptide;

public interface Fractionator {

    List<Peptide> fractionate(final Peptide peptide);

}
