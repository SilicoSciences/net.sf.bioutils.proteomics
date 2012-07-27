package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.PeakView;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

public class PeakViewMass extends AbstractTransformingListFactory<Peak, Double> implements
		PeakView<Double> {

	@Override
	public Double transform(Peak element) {
		return element.getMz();
	}

}
