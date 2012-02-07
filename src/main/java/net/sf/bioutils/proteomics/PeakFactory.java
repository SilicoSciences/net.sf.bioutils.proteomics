package net.sf.bioutils.proteomics;

import net.sf.kerner.utils.factory.Factory;

public interface PeakFactory<P extends Peak> extends Factory<P> {

	P create(double mz, double intensity);

}
