package net.sf.bioutils.proteomics;

import net.sf.kerner.utils.collections.list.FactoryList;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;
import net.sf.kerner.utils.math.UtilMath;

public class TransformerToLog2 extends AbstractTransformingListFactory<Double, Double> {

    public TransformerToLog2() {
        super();
    }

    public TransformerToLog2(final FactoryList<Double> factory) {
        super(factory);
    }

    @Override
    public Double transform(final Double element) {
        return UtilMath.log2(element);
    }

}
