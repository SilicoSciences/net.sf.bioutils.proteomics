package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class TransformerPeakToFractionNr extends AbstractTransformingListFactory<Peak, Integer> {

    @Override
    public Integer transform(final Peak element) {
        return element.getFraction().getIndex();
    }

}
