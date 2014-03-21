package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.provider.ProviderIntensity;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class TransformerIntensityProviderDouble extends
        AbstractTransformingListFactory<ProviderIntensity, Double> {

    @Override
    public Double transform(final ProviderIntensity element) {
        return Double.valueOf(element.getIntensity());
    }

}
