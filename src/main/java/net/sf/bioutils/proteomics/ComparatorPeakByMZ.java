package net.sf.bioutils.proteomics;

public class ComparatorPeakByMZ implements ComparatorPeak {

	public int compare(Peak o1, Peak o2) {

		return Double.compare(o1.getMZ(), o2.getMZ());

	}

}
