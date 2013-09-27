package net.sf.bioutils.proteomics.impl.transformer;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.list.FactoryList;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class TransformerPeakToSampleName extends AbstractTransformingListFactory<Peak, String> {

    public TransformerPeakToSampleName() {
        super();

    }

    public TransformerPeakToSampleName(final FactoryList<String> factory) {
        super(factory);

    }

    @Override
    public String transform(final Peak element) {
        return element.getSampleName();
    }

}
