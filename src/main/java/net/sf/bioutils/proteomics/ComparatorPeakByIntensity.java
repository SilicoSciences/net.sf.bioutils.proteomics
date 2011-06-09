package net.sf.bioutils.proteomics;

public class ComparatorPeakByIntensity implements ComparatorPeak {

	public int compare(Peak o1, Peak o2) {
		return Double.valueOf(o1.getIntensity()).compareTo(
				Double.valueOf(o2.getIntensity()));

	}

}
