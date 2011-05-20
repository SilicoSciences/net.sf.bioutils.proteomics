package net.sf.bioutils.proteomics;

public interface Peak {

	double getMZ();

	int getIntensity();

	String getName();

	int getIntensityToNoise();

}
