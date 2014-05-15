package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.sample.FactorySample;
import net.sf.bioutils.proteomics.sample.Sample;

public class FactorySamplePeaks implements FactorySample {

    private String name;

    @Override
    public SamplePeaks create() {
        return new SamplePeaks(name);
    }

    @Override
    public Sample create(final String name) {
        return new SamplePeaks(name, null);
    }

    @Override
    public Sample create(final String name, final User user) {
        return new SamplePeaks(name, user);
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(final String name) {
        this.name = name;
    }

}
