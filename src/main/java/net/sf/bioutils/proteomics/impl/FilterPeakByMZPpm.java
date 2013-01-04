package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.UtilPeak;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakByMZPpm<P extends Peak> implements Filter<P> {

	protected final double massShift;

	protected final double parentMass;

	public FilterPeakByMZPpm(final double massShift, final double parentMass) {
		super();
		this.massShift = massShift;
		this.parentMass = parentMass;
	}

	public boolean filter(final P element) {
		final double d = UtilPeak.getPpmDelta(parentMass,
				Math.abs(parentMass - element.getMz()));
		if (d <= massShift)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	@Override
	public String toString() {
		return "parentMass=" + parentMass + ",shift=" + massShift;
	}

}
