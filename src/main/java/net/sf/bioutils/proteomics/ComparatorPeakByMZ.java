package net.sf.bioutils.proteomics;

import java.util.Comparator;

public class ComparatorPeakByMZ implements Comparator<Peak> {

	public int compare(Peak o1, Peak o2) {

		return Double.compare(o1.getMZ(), o2.getMZ());

	}

}
