package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.ProteomicsUtils;
import net.sf.kerner.utils.collections.Filter;

public class PeakFilterByMassPpm<P extends Peak> implements Filter<P> {
	
	protected final double massShift;
	
	protected final P parent;

	public PeakFilterByMassPpm(double massShift, P parent) {
		super();
		this.massShift = massShift;
		this.parent = parent;
	}

	@Override
	public Boolean visit(P element) {
		final double d = ProteomicsUtils.getPpmDelta(parent.getMZ(), Math.abs(parent.getMZ() - element.getMZ()));
		if(d <= massShift)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	
	
}
