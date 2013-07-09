package net.sf.bioutils.proteomics;

import java.util.Collection;
import java.util.List;

public interface PeptideSequences extends Collection<Peptide> {

    public List<Double> asMassList();

}
