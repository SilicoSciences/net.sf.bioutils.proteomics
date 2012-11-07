package net.sf.bioutils.proteomics;

import java.util.List;

import net.sf.bioutils.proteomics.Fraction;

public interface SampleModifiable extends Sample {

    void setName(String name);

    void setFractions(List<? extends Fraction> fractions);

    void setNormalized(boolean normalized);

    void setParent(User user);

}
