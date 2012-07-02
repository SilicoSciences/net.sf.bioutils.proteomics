package net.sf.bioutils.proteomics;

import net.sf.kerner.utils.collections.list.FactoryList;

public interface FactoryStandard extends FactoryList<Standard> {

    Standard create(double mz, double intensity);

}
