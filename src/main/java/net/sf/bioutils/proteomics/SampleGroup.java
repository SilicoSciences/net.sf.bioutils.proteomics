package net.sf.bioutils.proteomics;

import java.util.Set;

public interface SampleGroup {

    void addSample(Sample sample);

    String getName();

    Set<Sample> getSamples();

    void removeSample(Sample ssample);

}
