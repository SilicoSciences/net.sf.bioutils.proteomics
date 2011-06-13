package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.PeakFactory;

public class PeakImplFactory implements PeakFactory<PeakImpl> {

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

<<<<<<< HEAD
=======
	public List<PeakImpl> createCollection() {
		final List<PeakImpl> result = new ArrayList<PeakImpl>();
		// TODO fill?!
		return result;
	}

	public List<PeakImpl> createCollection(Collection<? extends PeakImpl> elements) {
		final List<PeakImpl> result = new ArrayList<PeakImpl>();
		
		for(PeakImpl p : elements){
			result.add(create(p.getMZ(), p.getIntensity()));
		}
		
		return result;
	}

>>>>>>> 4cf391bda0fc14f04a6121a78cd1154c534efb86
}
