package net.sf.bioutils.proteomics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.collections.impl.ComparatorInverter;

public class FilterPeakMaxInt implements Filter<Peak> {

    private Set<Peak> set;

    private final int numElements;

    private volatile int cnt;

    public FilterPeakMaxInt(final Collection<? extends Peak> peaks, final int numElements) {
        this.numElements = numElements;
        if (peaks == null || peaks.isEmpty()) {
            // filter only on numElements
        } else {
            if (peaks.size() <= numElements) {
                set = new HashSet<Peak>(peaks);
            } else {
                final TreeSet<Peak> sett = new TreeSet<Peak>(new ComparatorInverter<Peak>(
                        new ComparatorPeakByIntensity()));
                sett.addAll(peaks);
                final List<Peak> list = new ArrayList<Peak>(sett);
                try {
                    set = new HashSet<Peak>(list.subList(0, numElements));
                } catch (final Exception e) {
                    e.printStackTrace();
                    set = new HashSet<Peak>(peaks);
                }
            }
        }
    }

    @Override
    public boolean filter(final Peak e) {
        if (set == null) {
            if (cnt < numElements) {
                cnt++;
                return true;
            } else {
                return false;
            }
        } else {
            return set.contains(e);
        }
    }

}
