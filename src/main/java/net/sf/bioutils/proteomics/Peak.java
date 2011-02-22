package net.sf.bioutils.proteomics;

import java.io.Serializable;

public interface Peak extends Serializable {

	double getMass();

	int getIntensity();

	Object getId();

	int getIntensityToNoise();

}
