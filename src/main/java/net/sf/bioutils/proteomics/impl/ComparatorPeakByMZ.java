package net.sf.bioutils.proteomics.impl;

import java.util.Comparator;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.collections.impl.ComparatorNull;

public class ComparatorPeakByMZ extends ComparatorNull<Peak> implements Comparator<Peak> {

	public int compareNonNull(Peak o1, Peak o2) {

		return Double.compare(o1.getMZ(), o2.getMZ());

	}

}
