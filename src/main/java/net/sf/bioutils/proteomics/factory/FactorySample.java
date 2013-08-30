package net.sf.bioutils.proteomics.factory;

import java.util.Collection;

import net.sf.bioutils.proteomics.Sample;
import net.sf.bioutils.proteomics.SampleGroup;
import net.sf.bioutils.proteomics.User;
import net.sf.kerner.utils.Factory;

public interface FactorySample extends Factory<Sample> {

    Sample create(String name, Sample parent);

    Sample create(String name, User user, Sample parent);

    Sample create(String name, User user, Sample parent, Collection<? extends SampleGroup> groups);

}
