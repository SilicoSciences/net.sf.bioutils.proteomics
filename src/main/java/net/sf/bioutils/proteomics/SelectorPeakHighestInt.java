package net.sf.bioutils.proteomics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import net.sf.bioutils.proteomics.comparator.ComparatorPeakByIntensity;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.ComparatorInverter;
import net.sf.kerner.utils.collections.Selector;

public class SelectorPeakHighestInt implements Selector<Peak> {

    @Override
    public Peak select(final Collection<? extends Peak> elements) {
        final ArrayList<Peak> list = new ArrayList<Peak>(elements);
        Collections.sort(list, new ComparatorInverter<Peak>(new ComparatorPeakByIntensity()));
        return list.get(0);
    }

}
