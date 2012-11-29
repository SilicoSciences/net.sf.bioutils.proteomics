package net.sf.bioutils.proteomics.factory;

import net.sf.bioutils.proteomics.Sample;
import net.sf.bioutils.proteomics.User;
import net.sf.kerner.utils.Factory;

public interface FactorySample extends Factory<Sample> {

    Sample create(String name);

    Sample create(String name, User user);

}
