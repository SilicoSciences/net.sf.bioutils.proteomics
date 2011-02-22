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
		this.id = id;
		this.mass = mass;
		this.intensity = intensity;
		this.intensityToNoise = intensityToNoise;
	}
	
	public PeakImpl(Object id, double mass, int intensity){
		this.id = id;
		this.mass = mass;
		this.intensity = intensity;
		this.intensityToNoise = intensity;
	}
	
	public PeakImpl(PeakImpl template){
		this.id = template.id;
		this.mass = template.mass;
		this.intensity = template.intensity;
		this.intensityToNoise = template.intensityToNoise;
	}
	
	public PeakImpl(Object id, PeakImpl template){
		this.id = id;
		this.mass = template.mass;
		this.intensity = template.intensity;
		this.intensityToNoise = template.intensityToNoise;
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

	public double getMass() {
		return mass;
	}

	public int getIntensity() {
		return intensity;
	}
	
	public Object getId() {
		if(id == null)
			return "null";
		return id;
	}

	public int getIntensityToNoise() {
		return intensityToNoise;
	}

	@Override
	public String toString() {
		return "mass="+mass + ",height="+intensity+",sn="+intensityToNoise+",id="+id;
	}

}
