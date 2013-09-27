package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.impl.transformer.TransformerPeakToIntensity;
import net.sf.bioutils.proteomics.provider.ProviderIntensity;
import net.sf.kerner.utils.math.UtilMath;

public class TransformerPeakToIntensityLog2 extends TransformerPeakToIntensity {

    @Override
    public Double transform(final ProviderIntensity element) {
        final Double result = UtilMath.log2(super.transform(element));
        return result;
    }

}
