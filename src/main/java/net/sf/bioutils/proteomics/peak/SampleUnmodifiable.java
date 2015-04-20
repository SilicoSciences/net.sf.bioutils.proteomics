package net.sf.bioutils.proteomics.peak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.sf.bioutils.proteomics.User;
import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.kerner.utils.Util;

public class SampleUnmodifiable implements Sample {

    private final Sample delegate;

    public SampleUnmodifiable(final Sample delegate) {
        Util.checkForNull(delegate);
        this.delegate = delegate;
    }

    @Override
    public SampleUnmodifiable clone() {
        return new SampleUnmodifiable(delegate.clone());
    }

    @Override
    public Sample clone(final String newName) {
        return new SampleUnmodifiable(delegate.clone(newName));
    }

    @Override
    public Sample cloneWOFractions() {
        return new SampleUnmodifiable(delegate.cloneWOFractions());
    }

    @Override
    public boolean equals(final Object obj) {
        return delegate.equals(obj);
    }

    @Override
    public List<Fraction> getFractions() {
        final List<Fraction> l = new ArrayList<Fraction>(
                new TransformerFractionToUnmodifiable().transformCollection(delegate.getFractions()));
        return Collections.unmodifiableList(l);
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public List<Peak> getPeaks() {
        final List<Peak> l = new ArrayList<Peak>(
                new TransformerPeakToUnmodifiable().transformCollection(delegate.getPeaks()));
        return Collections.unmodifiableList(l);
    }

    @Override
    public Properties getProperties() {
        return delegate.getProperties();
    }

    @Override
    public int getSize() {
        return delegate.getSize();
    }

    @Override
    public User getUser() {
        return delegate.getUser();
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public Iterator<Fraction> iterator() {
        return delegate.iterator();
    }

    @Override
    public void setFractions(final List<? extends Fraction> fraction) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setProperties(final Properties properties) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "SampleUnmodifiable:" + delegate;
    }

}
