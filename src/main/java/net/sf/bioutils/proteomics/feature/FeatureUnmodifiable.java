package net.sf.bioutils.proteomics.feature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.sf.bioutils.proteomics.Spectrum;
import net.sf.bioutils.proteomics.annotation.AnnotationSerializable;
import net.sf.bioutils.proteomics.annotation.FeatureAnnotatable;
import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.peak.FractionUnmodifiable;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.peak.SampleUnmodifiable;
import net.sf.bioutils.proteomics.peak.TransformerPeakToUnmodifiable;
import net.sf.bioutils.proteomics.sample.Sample;

public class FeatureUnmodifiable implements FeatureAnnotatable {

    private final FeatureAnnotatable delegate;

    public FeatureUnmodifiable(final Feature delegate) {
        this.delegate = (FeatureAnnotatable) delegate;
    }

    @Override
    public FeatureAnnotatable clone() {
        return new FeatureUnmodifiable(delegate.clone());
    }

    @Override
    public boolean equals(final Object obj) {
        return delegate.equals(obj);
    }

    @Override
    public Collection<AnnotationSerializable> getAnnotation() {
        return Collections.unmodifiableCollection(delegate.getAnnotation());
    }

    @Override
    public Fraction getFraction() {
        return new FractionUnmodifiable(delegate.getFraction());
    }

    @Override
    public int getFractionIndex() {
        return delegate.getFractionIndex();
    }

    @Override
    public int getIndexCenter() {
        return delegate.getIndexCenter();
    }

    @Override
    public int getIndexFirst() {
        return delegate.getIndexFirst();
    }

    @Override
    public int getIndexLast() {
        return delegate.getIndexLast();
    }

    @Override
    public double getIntensity() {
        return delegate.getIntensity();
    }

    @Override
    public double getIntensityToNoise() {
        return delegate.getIntensityToNoise();
    }

    @Override
    public List<Peak> getMembers() {
        final List<Peak> l = new ArrayList<Peak>(
                new TransformerPeakToUnmodifiable().transformCollection(delegate.getMembers()));
        return Collections.unmodifiableList(l);
    }

    @Override
    public double getMz() {
        return delegate.getMz();
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public Sample getSample() {
        return new SampleUnmodifiable(delegate.getSample());
    }

    @Override
    public String getSampleName() {
        return delegate.getSampleName();
    }

    @Override
    public Spectrum getSpectrum() {
        return delegate.getSpectrum();
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public Iterator<Peak> iterator() {
        return delegate.iterator();
    }

    @Override
    public void setAnnotation(final Collection<AnnotationSerializable> annotation) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFraction(final Fraction fraction) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSpectrum(final Spectrum spectra) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "FeatureUnmodifiable:" + delegate;
    }

}
