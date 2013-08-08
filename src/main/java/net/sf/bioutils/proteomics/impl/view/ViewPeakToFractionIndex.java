package net.sf.bioutils.proteomics.impl.view;

import net.sf.bioutils.proteomics.Fraction;
import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.impl.KeyValue;

public class ViewPeakToFractionIndex extends KeyValue<Peak, Integer> {

    public ViewPeakToFractionIndex(final Peak key) {
        super(key, key.getFractionIndex());
    }

}
