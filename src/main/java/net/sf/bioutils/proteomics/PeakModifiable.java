package net.sf.bioutils.proteomics;

public interface PeakModifiable extends Peak {

    void setIntensity(double intensity);

    void setName(String name);

}
