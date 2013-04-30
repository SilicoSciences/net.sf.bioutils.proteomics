package net.sf.bioutils.proteomics.impl;

import java.util.Collection;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakByFracNr implements Filter<Peak> {

    private final Collection<? extends Number> fracNr;

    public FilterPeakByFracNr(final Collection<? extends Number> fracNr) {
        this.fracNr = fracNr;
    }

    public boolean filter(final Peak element) {
        for (final Number n : fracNr) {
            if (element.getFractionIndex() == n.intValue()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "fracNr=" + fracNr;
    }
}
