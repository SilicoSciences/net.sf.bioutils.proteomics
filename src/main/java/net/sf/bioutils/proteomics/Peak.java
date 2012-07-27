package net.sf.bioutils.proteomics;

public interface Peak {

    double getIntensity();

    double getIntensityToNoise();

    double getMz();

    double getMz(MassUnit unit);

    String getName();

    double getSignalToNoiseRatio();

}
