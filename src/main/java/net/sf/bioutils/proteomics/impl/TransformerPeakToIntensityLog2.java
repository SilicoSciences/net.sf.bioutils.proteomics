package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;
import net.sf.kerner.utils.math.UtilMath;

public class TransformerPeakToIntensityLog2 extends AbstractTransformingListFactory<Peak, Double> {

    @Override
    public Double transform(final Peak element) {
        return UtilMath.log2(element.getIntensity());
    }

}
