package net.sf.bioutils.proteomics;

public interface Peak {

    Fraction getFraction();

    double getIntensity();

    double getIntensityToNoise();

    double getMz();

    double getMz(MassUnit unit);

    String getName();

    void setFraction(Fraction fraction);

}
