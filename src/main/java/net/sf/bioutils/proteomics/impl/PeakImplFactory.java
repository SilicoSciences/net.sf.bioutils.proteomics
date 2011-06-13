package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.PeakFactory;

public class PeakImplFactory implements PeakFactory<Peak> {

	protected final double mz;
	
	protected final double intensity;
	
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
	
	public PeakImpl create() {
		return new PeakImpl(mz, intensity);
	}
	
	public PeakImpl create(double mz, double intensity) {
		return new PeakImpl(mz, intensity);
	}

}
