package net.sf.bioutils.proteomics.impl.transformer;

import net.sf.bioutils.proteomics.provider.ProviderIntensity;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class TransformerPeakToIntensity extends AbstractTransformingListFactory<ProviderIntensity, Double> {

    @Override
    public Double transform(final ProviderIntensity element) {
        return element.getIntensity();
    }

}
