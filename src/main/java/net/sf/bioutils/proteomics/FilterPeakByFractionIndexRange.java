package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.jranges.range.integer.IntegerRange;
import net.sf.kerner.utils.collections.filter.Filter;

/**
 * A {@link Filter} that checks weather a given {@link Peak}'s fraction number
 * is within given {@link Range}.
 * <p>
 * <b>Example:</b><br>
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2013-10-18
 */
public class FilterPeakByFractionIndexRange implements Filter<Peak> {

    private final IntegerRange range;

    /**
     * Create a new {@code FilterPeakByMZRange}.
     * 
     * @param range
     *            m/z range in which a peak's m/z must be in in order for this
     *            {@code Filter} t accept this peak
     */
    public FilterPeakByFractionIndexRange(final IntegerRange range) {
        this.range = range;
    }

    @Override
    public boolean filter(final Peak element) {
        return range.includes(element.getFractionIndex());
    }

    @Override
    public String toString() {
        return "fracNrRange=" + range;
    }
}
