package net.sf.bioutils.proteomics;

import java.util.Comparator;

public class PeakComparatorByIntensity implements Comparator<Peak> {

	private final boolean smallestFirst;

	public PeakComparatorByIntensity() {
		smallestFirst = true;
	}

	public PeakComparatorByIntensity(boolean smallestFirst) {
		this.smallestFirst = smallestFirst;
	}

	public int compare(Peak o1, Peak o2) {
		if (smallestFirst)
			return Integer.valueOf(o1.getIntensity()).compareTo(Integer.valueOf(o2.getIntensity()));
		else
			return Integer.valueOf(o2.getIntensity()).compareTo(Integer.valueOf(o1.getIntensity()));
	}

}
