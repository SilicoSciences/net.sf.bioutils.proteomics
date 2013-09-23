package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.peak.FactoryPeak;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.peak.impl.PeakImpl;

public class FactoryPeakImpl implements FactoryPeak {

	public Peak create(final String name, final double mz,
			final double intensity, final double snRatio) {
		return new PeakImpl(name, mz, intensity, snRatio);
	}

}
