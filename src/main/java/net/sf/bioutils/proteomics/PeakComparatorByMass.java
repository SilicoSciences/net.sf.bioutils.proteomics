package net.sf.bioutils.proteomics;

import java.util.Comparator;

public class PeakComparatorByMass implements Comparator<Peak> {

	private final boolean smallestFirst;

	public PeakComparatorByMass() {
		smallestFirst = true;
	}

	public PeakComparatorByMass(boolean smallestFirst) {
		this.smallestFirst = smallestFirst;
	}

	public int compare(Peak o1, Peak o2) {
		if (smallestFirst)
			return Double.compare(o1.getMass(), o2.getMass());
		else
			return Double.compare(o2.getMass(), o1.getMass());
	}

}
