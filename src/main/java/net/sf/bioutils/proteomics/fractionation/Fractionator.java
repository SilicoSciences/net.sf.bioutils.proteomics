package net.sf.bioutils.proteomics.fractionation;

import java.util.List;

import net.sf.bioutils.proteomics.Peptide;

public interface Fractionator {

    List<Peptide> fractionate(final Peptide peptide);

}
