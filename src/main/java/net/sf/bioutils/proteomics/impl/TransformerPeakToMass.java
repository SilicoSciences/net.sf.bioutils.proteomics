package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class TransformerPeakToMass extends AbstractTransformingListFactory<Peak, Double> {

    @Override
    public Double transform(final Peak element) {
        return element.getMz();
    }

}
