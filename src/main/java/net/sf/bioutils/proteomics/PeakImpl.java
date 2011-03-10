package net.sf.bioutils.proteomics;

import java.util.ArrayList;
import java.util.List;

public class PeakImpl implements Peak {
	
	private static final long serialVersionUID = 4114258693936960376L;

	private final String id;
	
	private final double mz;
	
	private final int intensity;
	
	private final int intensityToNoise;
	
	public PeakImpl(String id, double mz, int intensity, int intensityToNoise){
		if(id == null)
			id = "null";
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
	
	public PeakImpl(PeakImpl template){
		this(template.getName(), template.getMassOverCharge(), template.getIntensity(), template.getIntensityToNoise());
	}
	
	public PeakImpl(String id, PeakImpl template){
		this(id, template.getMassOverCharge(), template.getIntensity(), template.getIntensityToNoise());
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
		
		result.add(mzToString(getMassOverCharge()));
		result.add(intensityToString(getIntensity()));
		result.add(intensityToNoise(getIntensityToNoise()));
		result.add(getName().toString());
		
		return result;
	}
	
	@Override
	public String toString() {
		return "id:"+id + ",mz:"+mz + ",intensity:"+intensity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + intensity;
		result = prime * result + intensityToNoise;
		long temp;
		temp = Double.doubleToLongBits(mz);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeakImpl other = (PeakImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intensity != other.intensity)
			return false;
		if (intensityToNoise != other.intensityToNoise)
			return false;
		if (Double.doubleToLongBits(mz) != Double
				.doubleToLongBits(other.mz))
			return false;
		return true;
	}

	public double getMassOverCharge() {
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
