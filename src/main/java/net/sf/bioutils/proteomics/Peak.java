package net.sf.bioutils.proteomics;

import java.util.ArrayList;
import java.util.List;

public class Peak {
	
	private final Object id;
	
	private final double mass;
	
	private final int intensity;
	
	private final int signalToNoise;
	
	public Peak(Object id, double mass, int intensity, int sn){
		this.id = id;
		this.mass = mass;
		this.intensity = intensity;
		this.signalToNoise = sn;
	}
	
	public Peak(Object id, double mass, int intensity){
		this.id = id;
		this.mass = mass;
		this.intensity = intensity;
		this.signalToNoise = intensity;
	}
	
	public Peak(Peak template){
		this.id = template.id;
		this.mass = template.mass;
		this.intensity = template.intensity;
		this.signalToNoise = template.signalToNoise;
	}
	
	public Peak(Object id, Peak template){
		this.id = id;
		this.mass = template.mass;
		this.intensity = template.intensity;
		this.signalToNoise = template.signalToNoise;
	}
	
	public static String massToString(double mass) {
		return String.format("%12.6f", mass);
	}

	public static String intensityToString(int intensity) {
		return String.format("%6d", intensity);
	}
	
	public static String signalToNoise(int sn) {
		return String.format("%6d", sn);
	}
	
	public List<String> toStringList(){
		final List<String> result = new ArrayList<String>();
		
		result.add(massToString(getMass()));
		result.add(intensityToString(getIntensity()));
		result.add(signalToNoise(getSn()));
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
		return id;
	}

	public int getSn() {
		return signalToNoise;
	}

	@Override
	public String toString() {
		return "mass="+mass + ",height="+intensity+",sn="+signalToNoise+",id="+id;
	}

}
