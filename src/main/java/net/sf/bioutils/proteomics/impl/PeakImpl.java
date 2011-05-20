package net.sf.bioutils.proteomics.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.Peak;

public class PeakImpl implements Peak {
	
	private static final long serialVersionUID = 4114258693936960376L;

	protected final String id;
	
	protected final double mz;
	
	protected final int intensity;
	
	protected final int intensityToNoise;
	
	public PeakImpl(String id, double mz, int intensity, int intensityToNoise){
		this.id = id;
		this.mz = mz;
		this.intensity = intensity;
		this.intensityToNoise = intensityToNoise;
	}
	
	public PeakImpl(String id, double mz, int intensity){
		this(id, mz, intensity, intensity);
	}
	
	public PeakImpl(double mz, int intensity){
		this(null, mz, intensity, intensity);
	}
	
	public PeakImpl(Peak template){
		this(template.getName(), template.getMZ(), template.getIntensity(), template.getIntensityToNoise());
	}
	
	public PeakImpl(String id, Peak template){
		this(id, template.getMZ(), template.getIntensity(), template.getIntensityToNoise());
	}
	
	public static String mzToString(double mz) {
		return String.format("%12.6f", mz);
	}

	public static String intensityToString(int intensity) {
		return String.format("%6d", intensity);
	}
	
	public static String intensityToNoise(int sn) {
		return String.format("%6d", sn);
	}
	
	public List<String> toStringList(){
		final List<String> result = new ArrayList<String>();
		
		result.add(mzToString(getMZ()));
		result.add(intensityToString(getIntensity()));
		result.add(intensityToNoise(getIntensityToNoise()));
		result.add(getName().toString());
		
		return result;
	}

	@Override
	public String toString() {
		return "mz:" + mz + ",int:" + intensity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + intensity;
		result = prime * result + intensityToNoise;
		long temp;
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
		if (intensity != other.intensity) {
			return false;
		}
		if (intensityToNoise != other.intensityToNoise) {
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

	public int getIntensity() {
		return intensity;
	}
	
	public String getName() {
		return id;
	}

	public int getIntensityToNoise() {
		return intensityToNoise;
	}

}
