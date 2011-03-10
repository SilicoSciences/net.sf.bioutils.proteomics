package net.sf.bioutils.proteomics;

import java.util.Comparator;

public class PeakComparatorByMZ implements Comparator<Peak> {

	private final boolean smallestFirst;

	public PeakComparatorByMZ() {
		smallestFirst = true;
	}

	public PeakComparatorByMZ(boolean smallestFirst) {
		this.smallestFirst = smallestFirst;
	}

	public int compare(Peak o1, Peak o2) {
		if (smallestFirst)
			return Double.compare(o1.getMassOverCharge(), o2.getMassOverCharge());
		else
			return Double.compare(o2.getMassOverCharge(), o1.getMassOverCharge());
	}

}
