package net.sf.bioutils.proteomics;

import java.util.Comparator;

public class PeakComparatorByIntensity implements Comparator<Peak> {

	public int compare(Peak o1, Peak o2) {
		return Integer.valueOf(o1.getIntensity()).compareTo(
				Integer.valueOf(o2.getIntensity()));

	}

}
