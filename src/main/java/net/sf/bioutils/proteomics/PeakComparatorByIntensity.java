package net.sf.bioutils.proteomics;

import java.util.Comparator;

public class PeakComparatorByIntensity implements Comparator<Peak> {

	public int compare(Peak o1, Peak o2) {
		return Double.valueOf(o1.getIntensity()).compareTo(
				Double.valueOf(o2.getIntensity()));

	}

}
