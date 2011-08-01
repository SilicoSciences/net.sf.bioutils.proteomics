package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.doublerange.impl.DummyDoubleRange;
import net.sf.kerner.utils.collections.Filter;

/**
 * 
 * A {@code Filter} that checks weather a given {@code Peak's} m/z is within a
 * given {@code Range}.
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
 * @version 2011-08-01
 * 
 * @param <P>
 */
public class PeakFilterByMass<P extends Peak> implements Filter<P> {

	private final DoubleRange range;

	/**
	 * 
	 * Create a new {@code PeakFilterByMass}.
	 * 
	 * @param range
	 *            m/z range in which a peak's m/z must be in in order for this
	 *            {@code Filter} t accept this peak
	 */
	public PeakFilterByMass(DoubleRange range) {
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
	public PeakFilterByMass(double mass) {
		this.range = new DummyDoubleRange(mass, mass);
	}

	public Boolean visit(P element) {
		return range.includes(element.getMZ());
	}

}
