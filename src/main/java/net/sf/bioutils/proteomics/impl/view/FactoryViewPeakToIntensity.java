package net.sf.bioutils.proteomics.impl.view;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.list.FactoryList;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class FactoryViewPeakToIntensity extends AbstractTransformingListFactory<Peak, ViewPeakToIntensity> {

    public FactoryViewPeakToIntensity() {
        super();
    }

    public FactoryViewPeakToIntensity(final FactoryList<ViewPeakToIntensity> factory) {
        super(factory);
    }

    @Override
    public ViewPeakToIntensity transform(final Peak element) {
        return new ViewPeakToIntensity(element);
    }

}
