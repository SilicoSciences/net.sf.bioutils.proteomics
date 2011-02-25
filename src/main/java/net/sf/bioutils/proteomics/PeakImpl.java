package net.sf.bioutils.proteomics;

import java.util.ArrayList;
import java.util.List;

public class PeakImpl implements Peak {
	
	private static final long serialVersionUID = 4114258693936960376L;

	private final Object id;
	
	private final double mass;
	
	private final int intensity;
	
	private final int intensityToNoise;
	
	public PeakImpl(Object id, double mass, int intensity, int intensityToNoise){
		if(id == null)
			id = "null";
		this.id = id;
		this.mass = mass;
		this.intensity = intensity;
		this.intensityToNoise = intensityToNoise;
	}
	
	public PeakImpl(Object id, double mass, int intensity){
		this(id, mass, intensity, intensity);
	}
	
	public PeakImpl(double mass, int intensity){
		this(null, mass, intensity, intensity);
	}
	
	public PeakImpl(PeakImpl template){
		this(template.getId(), template.getMass(), template.getIntensity(), template.getIntensityToNoise());
	}
	
	public PeakImpl(Object id, PeakImpl template){
		this(id, template.getMass(), template.getIntensity(), template.getIntensityToNoise());
	}
	
	public static String massToString(double mass) {
		return String.format("%12.6f", mass);
	}

	public static String intensityToString(int intensity) {
		return String.format("%6d", intensity);
	}
	
	public static String intensityToNoise(int sn) {
		return String.format("%6d", sn);
	}
	
	public List<String> toStringList(){
		final List<String> result = new ArrayList<String>();
		
		result.add(massToString(getMass()));
		result.add(intensityToString(getIntensity()));
		result.add(intensityToNoise(getIntensityToNoise()));
		result.add(getId().toString());
		
		return result;
	}
	
	@Override
	public String toString() {
		return "id:"+id + ",mass:"+mass + ",intensity:"+intensity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + intensity;
		result = prime * result + intensityToNoise;
		long temp;
		temp = Double.doubleToLongBits(mass);
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
		if (Double.doubleToLongBits(mass) != Double
				.doubleToLongBits(other.mass))
			return false;
		return true;
	}

	public double getMass() {
		return mass;
	}

	public int getIntensity() {
		return intensity;
	}
	
	public Object getId() {
		return id;
	}

	public int getIntensityToNoise() {
		return intensityToNoise;
	}

}
