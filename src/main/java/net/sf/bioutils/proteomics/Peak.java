package net.sf.bioutils.proteomics;

public interface Peak {
	
	String getName();

	double getMZ();
	
	double getMZ(MassUnit unit);

	double getIntensity();

	double getIntensityToNoise();

}
