package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.factory.Factory;

public class PeakImplFactory implements Factory<Peak>{

	private final double mz;
	
	private final double intensity;
	
	public PeakImplFactory() {
		super();
		this.intensity = -1;
		this.mz = -1;
	}
	
	public PeakImplFactory(double mz, double intensity) {
		super();
		this.intensity = intensity;
		this.mz = mz;
	}
	
	public Peak create() {
		return new PeakImpl(mz, intensity);
	}
	
	public Peak create(double mz, double intensity) {
		return new PeakImpl(mz, intensity);
	}

}
