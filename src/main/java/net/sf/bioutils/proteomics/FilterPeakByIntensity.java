package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.doublerange.impl.DummyDoubleRange;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakByIntensity implements Filter<Peak> {

    public static enum TYPE {
        EXACT, MIN, MAX
    }

    private final DoubleRange range;

    public FilterPeakByIntensity(final double intensity, final TYPE type) {
        switch (type) {
            case EXACT:
                range = new DummyDoubleRange(intensity, intensity);
                break;
            case MIN:
                range = new DummyDoubleRange(intensity, Double.MAX_VALUE);
                break;
            case MAX:
                range = new DummyDoubleRange(Double.MIN_VALUE, intensity);
                break;
            default:
                throw new IllegalArgumentException("unknown type " + type);
        }

    }

    public FilterPeakByIntensity(final DoubleRange range) {
        this.range = range;
    }

    @Override
    public boolean filter(final Peak element) {
        return range.includes(element.getIntensity());
    }

}