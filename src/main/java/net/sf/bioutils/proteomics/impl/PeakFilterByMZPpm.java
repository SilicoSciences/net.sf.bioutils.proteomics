package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.ProteomicsUtils;
import net.sf.kerner.utils.collections.filter.Filter;

public class PeakFilterByMZPpm<P extends Peak> implements Filter<P> {

    protected final double massShift;

    protected final double parentMass;

    public PeakFilterByMZPpm(final double massShift, final double parentMass) {
        super();
        this.massShift = massShift;
        this.parentMass = parentMass;
    }

    @Override
    public boolean filter(final P element) {
        final double d = ProteomicsUtils.getPpmDelta(parentMass, Math.abs(parentMass - element.getMz()));
        if (d <= massShift)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    @Override
    public String toString() {
        return "parentMass=" + parentMass + ",shift=" + massShift;
    }

}
