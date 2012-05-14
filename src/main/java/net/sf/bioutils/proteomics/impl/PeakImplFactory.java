package net.sf.bioutils.proteomics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

	@Override
	public List<Peak> createCollection() {
		final List<Peak> result = new ArrayList<Peak>();
		return result;
	}

	@Override
	public List<Peak> createCollection(Collection<? extends Peak> template) {
		final List<Peak> result = new ArrayList<Peak>(template);
		return result;
	}

}
