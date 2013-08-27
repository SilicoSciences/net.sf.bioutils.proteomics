package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.math.UtilMath;

public class TransformerPeakToIntensityLog2 extends TransformerPeakToIntensity {

    @Override
    public Double transform(final Peak element) {
        return UtilMath.log2(super.transform(element));
    }

}
