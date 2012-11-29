package net.sf.bioutils.proteomics.factory;

import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.Fraction;
import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.Standard;
import net.sf.kerner.utils.Factory;

public interface FactoryFraction extends Factory<Fraction> {

    Fraction create(String name);

    Fraction create(String name, List<Peak> peaks, ArrayList<Standard> standards);

}
