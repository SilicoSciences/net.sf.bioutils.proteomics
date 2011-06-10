package net.sf.bioutils.proteomics;

import net.sf.kerner.utils.collections.list.ListFactory;
import net.sf.kerner.utils.factory.Factory;

public interface PeakFactory<P extends Peak> extends Factory<P>, ListFactory<P>{
	
	P create(double mz, double intensity);

}
