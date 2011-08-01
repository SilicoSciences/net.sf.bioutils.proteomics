package net.sf.bioutils.proteomics;

import java.util.Comparator;

public class ComparatorPeakByIntensity implements Comparator<Peak> {

	public int compare(Peak o1, Peak o2) {
		return Double.compare(o1.getIntensity(), o2.getIntensity());

	}

}
