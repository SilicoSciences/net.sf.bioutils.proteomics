package net.sf.bioutils.proteomics.impl;

import java.util.Comparator;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.impl.ComparatorNull;

public class ComparatorPeakByIntensity extends ComparatorNull<Peak> implements Comparator<Peak> {

    @Override
    public int compareNonNull(final Peak o1, final Peak o2) {
        return Double.compare(o1.getIntensity(), o2.getIntensity());

    }

}
