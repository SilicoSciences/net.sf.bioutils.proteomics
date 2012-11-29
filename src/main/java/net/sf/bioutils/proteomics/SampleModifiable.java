package net.sf.bioutils.proteomics;

public interface SampleModifiable extends Sample {

    void adddFraction(Fraction fraction);

    void setName(String name);

    void setParent(User user);

}
