package net.sf.bioutils.proteomics;

public class ComparatorPeakByIntensity implements ComparatorPeak {

	public int compare(Peak o1, Peak o2) {
		return Double.compare(o1.getIntensity(), o2.getIntensity());

	}

}
