package net.sf.bioutils.proteomics.impl;

import java.util.Comparator;

import net.sf.bioutils.proteomics.Peak;

public class ComparatorPeakByMZ implements Comparator<Peak> {

	public int compare(Peak o1, Peak o2) {

		return Double.compare(o1.getMZ(), o2.getMZ());

	}

}
