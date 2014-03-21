package net.sf.bioutils.proteomics.view;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.pair.KeyValue;

public class ViewPeakToFractionIndex extends KeyValue<Peak, Integer> {

    public ViewPeakToFractionIndex(final Peak key) {
        super(key, key.getFractionIndex());
    }

}
