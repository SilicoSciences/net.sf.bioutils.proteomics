package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.doublerange.impl.DummyDoubleRange;
import net.sf.kerner.utils.collections.Filter;

public class PeakFilterByIntensity<P extends Peak> implements Filter<P> {
	
	private final DoubleRange range;

	public PeakFilterByIntensity(DoubleRange range) {
		this.range = range;
	}
	
	public PeakFilterByIntensity(double intensity) {
		this.range = new DummyDoubleRange(intensity, intensity);
	}
	
	public Boolean visit(P element) {
		return range.includes(element.getIntensity());
	}

}
