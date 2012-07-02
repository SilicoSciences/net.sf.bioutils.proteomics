package net.sf.bioutils.proteomics;

import net.sf.kerner.utils.Factory;
import net.sf.kerner.utils.collections.list.FactoryList;

public interface PeakFactory extends Factory<Peak>, FactoryList<Peak> {

	Peak create(double mz, double intensity);

}
