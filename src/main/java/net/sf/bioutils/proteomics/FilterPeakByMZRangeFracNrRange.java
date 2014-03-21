package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.integer.IntegerRange;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakByMZRangeFracNrRange implements Filter<Peak> {

    private final IntegerRange fracRange;

    private final DoubleRange mzRange;

    public FilterPeakByMZRangeFracNrRange(final IntegerRange fracRange, final DoubleRange mzRange) {
        this.fracRange = fracRange;
        this.mzRange = mzRange;
    }

    @Override
    public boolean filter(final Peak e) {
        return fracRange.includes(e.getFractionIndex()) && mzRange.includes(e.getMz());
    }

}
