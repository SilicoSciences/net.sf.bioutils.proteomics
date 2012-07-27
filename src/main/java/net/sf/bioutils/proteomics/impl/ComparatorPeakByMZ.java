package net.sf.bioutils.proteomics.impl;

import java.util.Comparator;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.impl.ComparatorNull;

public class ComparatorPeakByMZ<P extends Peak> extends ComparatorNull<P> implements Comparator<P> {

	public int compareNonNull(P o1, P o2) {

		return Double.compare(o1.getMz(), o2.getMz());

	}

}
