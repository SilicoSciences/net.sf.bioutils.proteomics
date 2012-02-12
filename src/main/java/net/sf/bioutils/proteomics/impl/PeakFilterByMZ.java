package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.doublerange.impl.DummyDoubleRange;
import net.sf.kerner.utils.collections.Filter;

/**
 * 
 * A {@link Filter} that checks weather a given {@link Peak Peak's} {@code m/z} is
 * within a given {@link Range}.
 * 
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2012-02-12
 * 
 */
public class PeakFilterByMZ<P extends Peak> implements Filter<P> {

	private final DoubleRange range;

	/**
	 * 
	 * Create a new {@code PeakFilterByMass}.
	 * 
	 * @param range
	 *            m/z range in which a peak's m/z must be in in order for this
	 *            {@code Filter} t accept this peak
	 */
	public PeakFilterByMZ(DoubleRange range) {
		this.range = range;
	}

	/**
	 * 
	 * Create a new {@code PeakFilterByMass}.
	 * 
	 * @param mass
	 *            m/z that must be equal to a peak's m/z in order for this
	 *            {@code Filter} t accept this peak
	 */
	public PeakFilterByMZ(double mass) {
		this.range = new DummyDoubleRange(mass, mass);
	}

	/**
	 * 
	 * If {@code element} is {@code null}, {@code false} is returned.
	 * 
	 * @return {@code true} if this peak's m/z is valid; false otherwise
	 */
	public Boolean visit(P element) {
		if(element == null)
			return false;
		return range.includes(element.getMZ());
	}

	@Override
	public String toString() {
		return "massRange=" + range;
	}

}
