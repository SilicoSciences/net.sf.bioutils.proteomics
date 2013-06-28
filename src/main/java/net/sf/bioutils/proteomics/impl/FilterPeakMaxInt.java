package net.sf.bioutils.proteomics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.collections.impl.ComparatorInverter;

public class FilterPeakMaxInt implements Filter<Peak> {

    private Set<Peak> set;

    public FilterPeakMaxInt(final Collection<? extends Peak> peaks, final int numElements) {

        if (peaks.size() <= numElements) {
            set = new HashSet<Peak>(peaks);
        } else {
            final TreeSet<Peak> sett = new TreeSet<Peak>(new ComparatorInverter<Peak>(new ComparatorPeakByIntensity()));
            sett.addAll(peaks);
            final List<Peak> list = new ArrayList<Peak>(sett);
            set = new HashSet<Peak>(list.subList(0, numElements));
        }

    }

    @Override
    public boolean filter(final Peak e) {
        return set.contains(e);
    }

}
