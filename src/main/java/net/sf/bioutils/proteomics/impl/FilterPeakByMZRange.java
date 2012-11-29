package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.kerner.utils.collections.filter.Filter;

/**
 * A {@link Filter} that checks weather a given {@link Peak}'s {@code m/z} is within a given {@link Range}.
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
 * @version 2011-09-30
 */
public class FilterPeakByMZRange implements Filter<Peak> {

    private final DoubleRange range;

    /**
     * Create a new {@code PeakFilterByMass}.
     * 
     * @param range
     *            m/z range in which a peak's m/z must be in in order for this {@code Filter} t accept this peak
     */
    public FilterPeakByMZRange(final DoubleRange range) {
        this.range = range;
    }

    @Override
    public boolean filter(final Peak element) {
        return range.includes(element.getMz());
    }

    @Override
    public String toString() {
        return "massRange=" + range;
    }
}
