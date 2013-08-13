package net.sf.bioutils.proteomics.peptides;

import java.util.Collection;
import java.util.List;


public interface PeptideSequences extends Collection<Peptide> {

    public List<Double> asMassList();

}
