package net.sf.bioutils.proteomics.comparator;

import java.util.Comparator;

import net.sf.bioutils.proteomics.peak.Peak;

public class ComparatorPeakByIntensity implements Comparator<Peak> {

    private final static ComparatorIntensity COMPARATOR_INTENSITY = new ComparatorIntensity();

    @Override
    public int compare(final Peak o1, final Peak o2) {
        return COMPARATOR_INTENSITY.compare(o1, o2);
    }

}
