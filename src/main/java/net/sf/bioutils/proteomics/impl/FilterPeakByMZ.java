package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.math.UtilMath;

public class FilterPeakByMZ implements Filter<Peak> {

    public static int DEFAULT_ACCURACY = 1;

    private final int accuracy;

    private final double mz;

    public FilterPeakByMZ(final double mz) {
        this(mz, DEFAULT_ACCURACY);
    }

    public FilterPeakByMZ(final double mz, final int accuracy) {
        this.accuracy = accuracy;
        this.mz = mz;
    }

    @Override
    public boolean filter(final Peak element) {
        return UtilMath.round(element.getMz(), accuracy) == UtilMath.round(mz, accuracy);
    }

    @Override
    public String toString() {
        return "mz=" + mz + ",accuracy=" + accuracy;
    }
}
