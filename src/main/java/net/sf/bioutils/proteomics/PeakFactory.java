package net.sf.bioutils.proteomics;

import net.sf.kerner.utils.Factory;
import net.sf.kerner.utils.collections.list.ListFactory;

public interface PeakFactory<P extends Peak> extends Factory<P>, ListFactory<P> {

	P create(double mz, double intensity);

}
