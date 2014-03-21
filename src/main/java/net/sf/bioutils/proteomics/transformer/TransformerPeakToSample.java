package net.sf.bioutils.proteomics.transformer;

import net.sf.bioutils.proteomics.provider.ProviderSample;
import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.kerner.utils.collections.list.FactoryList;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class TransformerPeakToSample extends
        AbstractTransformingListFactory<ProviderSample, Sample> {

    public TransformerPeakToSample() {
        super();

    }

    public TransformerPeakToSample(final FactoryList<Sample> factory) {
        super(factory);

    }

    @Override
    public Sample transform(final ProviderSample element) {
        return element.getSample();
    }

}
