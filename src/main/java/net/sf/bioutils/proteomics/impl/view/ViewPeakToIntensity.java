package net.sf.bioutils.proteomics.impl.view;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.impl.KeyValue;

public class ViewPeakToIntensity extends KeyValue<Peak, Double> implements Comparable<ViewPeakToIntensity> {

    public ViewPeakToIntensity(final Peak key) {
        super(key, key.getIntensity());
    }

    @Override
    public int compareTo(final ViewPeakToIntensity o) {
        return getValue().compareTo(o.getValue());
    }

}
