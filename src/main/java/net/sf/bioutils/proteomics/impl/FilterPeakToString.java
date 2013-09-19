package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakToString implements Filter<Peak> {

    private final String text;

    public FilterPeakToString(final String text) {
        this.text = text;
    }

    @Override
    public boolean filter(final Peak e) {
        final String toString = e.toString();
        final boolean matches = toString.matches(".*(?i)" + text + ".*");
        return matches;
    }

}
