package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.list.AbstractTransformingListFactory;

public class PeakMassExtractor<P extends Peak> extends AbstractTransformingListFactory<P, Double>{

	@Override
	public Double transform(P element) {
		return element.getMZ();
	}

}
