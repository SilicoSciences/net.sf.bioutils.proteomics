package net.sf.bioutils.proteomics;

import java.util.Collections;
import java.util.Set;

import net.sf.kerner.utils.collections.set.impl.UtilSet;

public class SampleGroupImpl implements SampleGroup {

    private String name;

    private Set<Sample> samples = UtilSet.newSet();

    public SampleGroupImpl(final String name) {
        super();
        this.name = name;
    }

    @Override
    public void addSample(final Sample sample) {
        samples.add(sample);
    }

    @Override
    public synchronized String getName() {
        return name;
    }

    @Override
    public synchronized Set<Sample> getSamples() {
        return Collections.unmodifiableSet(samples);
    }

    public synchronized void setName(final String name) {
        this.name = name;
    }

    public synchronized void setSamples(final Set<Sample> samples) {
        this.samples = samples;
    }

    @Override
    public String toString() {
        return name;
    }

}
