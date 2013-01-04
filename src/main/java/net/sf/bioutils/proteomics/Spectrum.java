package net.sf.bioutils.proteomics;

import java.util.List;

public interface Spectrum extends Iterable<Peak> {

    String getName();

    double getParentMass();

    List<Peak> getPeaks();

}
