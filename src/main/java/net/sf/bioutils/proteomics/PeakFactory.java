package net.sf.bioutils.proteomics;

import net.sf.kerner.utils.collections.list.ListFactory;
import net.sf.kerner.utils.factory.Factory;

public interface PeakFactory extends Factory<Peak>, ListFactory<Peak>{
	
	Peak create(double mz, double intensity);

}
