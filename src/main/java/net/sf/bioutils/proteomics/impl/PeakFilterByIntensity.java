package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.doublerange.impl.DummyDoubleRange;
import net.sf.kerner.utils.collections.filter.Filter;

public class PeakFilterByIntensity implements Filter<Peak> {

    public static enum TYPE {
        EXACT, MIN, MAX
    }

    private final DoubleRange range;

    public PeakFilterByIntensity(final DoubleRange range) {
        this.range = range;
    }

    public PeakFilterByIntensity(final double intensity, final TYPE type) {
        switch (type) {
        case EXACT:
            this.range = new DummyDoubleRange(intensity, intensity);
            break;
        case MIN:
            this.range = new DummyDoubleRange(intensity, Double.MAX_VALUE);
            break;
        case MAX:
            this.range = new DummyDoubleRange(Double.MIN_VALUE, intensity);
            break;
        default:
            throw new IllegalArgumentException("unknown type " + type);
        }

    }

    @Override
    public boolean filter(final Peak element) {
        return range.includes(element.getIntensity());
    }

}
