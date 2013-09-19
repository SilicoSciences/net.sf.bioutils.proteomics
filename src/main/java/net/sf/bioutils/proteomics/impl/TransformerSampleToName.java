package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Sample;
import net.sf.kerner.utils.collections.list.FactoryList;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class TransformerSampleToName extends AbstractTransformingListFactory<Sample, String> {

    public TransformerSampleToName() {
        super();
    }

    public TransformerSampleToName(final FactoryList<String> factory) {
        super(factory);
    }

    @Override
    public String transform(final Sample element) {
        return element.getName();
    }

}
