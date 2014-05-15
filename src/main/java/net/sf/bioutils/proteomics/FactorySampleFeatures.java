package net.sf.bioutils.proteomics;


public class FactorySampleFeatures extends FactorySamplePeaks {

    @Override
    public SampleFeatures create() {
        return new SampleFeatures(getName());
    }

    @Override
    public SampleFeatures create(final String name) {
        return new SampleFeatures(name);
    }

    @Override
    public SampleFeatures create(final String name, final User user) {
        return new SampleFeatures(name, user);
    }

}
