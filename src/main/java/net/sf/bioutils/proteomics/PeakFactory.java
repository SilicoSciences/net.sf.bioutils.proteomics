package net.sf.bioutils.proteomics;

import net.sf.kerner.utils.factory.Factory;

public interface PeakFactory extends Factory<Peak> {
	
	Peak create(double mz, double intensity);

}
