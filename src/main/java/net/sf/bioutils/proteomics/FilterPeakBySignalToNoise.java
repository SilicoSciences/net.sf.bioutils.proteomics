package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakBySignalToNoise implements Filter<Peak> {

    public static enum Type {
        ABOVE, BELOW
    }

    private final double snRatio;

    private final Type type;

    public FilterPeakBySignalToNoise(final double snRatio, final Type type) {
        super();
        this.snRatio = snRatio;
        this.type = type;
    }

    @Override
    public boolean filter(final Peak e) {
        switch (type) {
            case BELOW:
                return e.getIntensityToNoise() < snRatio;
            case ABOVE:
                return e.getIntensityToNoise() > snRatio;
            default:
                throw new RuntimeException("unknown type " + type);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + type + " " + snRatio;
    }

}
