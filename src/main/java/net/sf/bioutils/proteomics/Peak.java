package net.sf.bioutils.proteomics;

public interface Peak {
	
	String getName();

	double getMZ();

	double getIntensity();

	double getIntensityToNoise();

}
