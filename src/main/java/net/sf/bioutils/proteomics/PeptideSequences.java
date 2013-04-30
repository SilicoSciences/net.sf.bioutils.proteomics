package net.sf.bioutils.proteomics;

import java.util.Collection;
import java.util.List;

public interface PeptideSequences extends Collection<PeptideSequence> {

    public List<Double> asMassList();

}
