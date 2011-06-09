package net.sf.bioutils.proteomics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.PeakFactory;

public class PeakImplFactory implements PeakFactory {

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
	
	public Peak create() {
		return new PeakImpl(mz, intensity);
	}
	
	public Peak create(double mz, double intensity) {
		return new PeakImpl(mz, intensity);
	}

	public List<Peak> createCollection() {
		final List<Peak> result = new ArrayList<Peak>();
		// TODO fill?!
		return result;
	}

	public List<Peak> createCollection(Collection<? extends Peak> elements) {
		final List<Peak> result = new ArrayList<Peak>();
		
		for(Peak p : elements){
			result.add(create(p.getMZ(), p.getIntensity()));
		}
		
		return result;
	}

}
