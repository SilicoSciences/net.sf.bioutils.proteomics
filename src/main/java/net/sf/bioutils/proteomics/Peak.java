package net.sf.bioutils.proteomics;

import java.io.Serializable;

public interface Peak extends Serializable {

	double getMassOverCharge();

	int getIntensity();

	String getName();

	int getIntensityToNoise();

}
