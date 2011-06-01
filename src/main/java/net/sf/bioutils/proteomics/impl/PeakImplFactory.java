package net.sf.bioutils.proteomics.impl;

import net.sf.kerner.utils.factory.Factory;

public class PeakImplFactory implements Factory<PeakImpl>{

	private final double mz;
	
	private final double intensity;
	
	public PeakImplFactory(double mz, double intensity) {
		super();
		this.intensity = intensity;
		this.mz = mz;
	}
	
	public PeakImpl create() {
		return new PeakImpl(mz, intensity);
	}

}
