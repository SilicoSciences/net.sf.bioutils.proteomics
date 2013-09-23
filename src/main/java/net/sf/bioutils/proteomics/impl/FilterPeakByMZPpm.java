package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakByMZPpm<P extends Peak> implements Filter<P> {

    protected final double massShift;

    protected final double parentMass;

    public FilterPeakByMZPpm(final double massShift, final double parentMass) {
        super();
        this.massShift = massShift;
        this.parentMass = parentMass;
    }

    public boolean filter(final P element) {
        final double d = (parentMass - element.getMz()) * 1000000 / parentMass;
        if (Math.abs(d) <= massShift) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public String toString() {
        return "parentMass=" + parentMass + ",shift=" + massShift;
    }

}
