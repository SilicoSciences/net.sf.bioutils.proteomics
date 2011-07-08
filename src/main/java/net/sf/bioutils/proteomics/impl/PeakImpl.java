package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.MassUnit;
import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.Standard;

public class PeakImpl implements Peak, Standard {
	
	public final static MassUnit DEFAULT_UNIT = MassUnit.DALTON;

	protected final String name;
	
	protected final double mz;
	
	protected final double intensity;
	
	protected final double intensityToNoise;
	
	public PeakImpl(String id, double mz, double intensity, double intensityToNoise){
		this.name = id;
		this.mz = mz;
		this.intensity = intensity;
		this.intensityToNoise = intensityToNoise;
	}
	
	public PeakImpl(String id, double mz, double intensity){
		this(id, mz, intensity, intensity);
	}
	
	public PeakImpl(double mz, double intensity){
		this(null, mz, intensity, intensity);
	}
	
	public PeakImpl(Peak template){
		this(template.getName(), template.getMZ(), template.getIntensity(), template.getIntensityToNoise());
	}
	
	public PeakImpl(String id, Peak template){
		this(id, template.getMZ(), template.getIntensity(), template.getIntensityToNoise());
	}

	@Override
	public String toString() {
		return "mz:" + mz + ",int:" + intensity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(intensity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(intensityToNoise);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mz);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PeakImpl)) {
			return false;
		}
		PeakImpl other = (PeakImpl) obj;
		if (Double.doubleToLongBits(intensity) != Double
				.doubleToLongBits(other.intensity)) {
			return false;
		}
		if (Double.doubleToLongBits(intensityToNoise) != Double
				.doubleToLongBits(other.intensityToNoise)) {
			return false;
		}
		if (Double.doubleToLongBits(mz) != Double.doubleToLongBits(other.mz)) {
			return false;
		}
		return true;
	}

	public double getMZ() {
		return mz;
	}

	public double getMZ(MassUnit unit) {
		return DEFAULT_UNIT.convert(mz, unit);
	}
	
	public double getIntensity() {
		return intensity;
	}
	
	public String getName() {
		return name;
	}

	public double getIntensityToNoise() {
		return intensityToNoise;
	}

}
