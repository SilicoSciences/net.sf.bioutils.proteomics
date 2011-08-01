package net.sf.bioutils.proteomics.impl;

import java.util.Comparator;

import net.sf.bioutils.proteomics.Peak;

public class ComparatorPeakByIntensity implements Comparator<Peak> {

	public int compare(Peak o1, Peak o2) {
		return Double.compare(o1.getIntensity(), o2.getIntensity());

	}

}
