package net.sf.bioutils.proteomics.view;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.list.FactoryList;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class FactoryViewPeakToFractionIndex extends AbstractTransformingListFactory<Peak, ViewPeakToFractionIndex> {

    public FactoryViewPeakToFractionIndex() {
        super();
    }

    public FactoryViewPeakToFractionIndex(final FactoryList<ViewPeakToFractionIndex> factory) {
        super(factory);
    }

    @Override
    public ViewPeakToFractionIndex transform(final Peak element) {
        return new ViewPeakToFractionIndex(element);
    }
}
