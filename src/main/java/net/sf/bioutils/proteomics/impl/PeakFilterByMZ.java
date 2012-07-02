package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.math.MathUtils;

public class PeakFilterByMZ implements Filter<Peak> {

    public static int DEFAULT_ACCURACY = 4;

    private final double mz;

    private final int accuracy;

    public PeakFilterByMZ(final double mz, final int accuracy) {
        this.accuracy = accuracy;
        this.mz = mz;
    }

    public PeakFilterByMZ(final double mz) {
        this(mz, DEFAULT_ACCURACY);
    }

    @Override
    public boolean filter(final Peak element) {
        return MathUtils.round(element.getMZ(), accuracy) == MathUtils.round(mz, accuracy);
    }

    @Override
    public String toString() {
        return "mz=" + mz + ",accuracy=" + accuracy;
    }
}
