package net.sf.bioutils.proteomics;

import java.util.List;

public interface Spectra extends Iterable<Peak> {

    String getName();

    double getParentMass();

    List<Peak> getPeaks();

}
