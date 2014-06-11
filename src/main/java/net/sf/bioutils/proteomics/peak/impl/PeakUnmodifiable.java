package net.sf.bioutils.proteomics.peak.impl;

import java.util.Collection;
import java.util.Collections;

import net.sf.bioutils.proteomics.Spectrum;
import net.sf.bioutils.proteomics.annotation.AnnotationSerializable;
import net.sf.bioutils.proteomics.annotation.PeakAnnotatable;
import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.peak.FractionUnmodifiable;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.peak.SampleUnmodifiable;
import net.sf.bioutils.proteomics.sample.Sample;

public class PeakUnmodifiable implements PeakAnnotatable {

    private final PeakAnnotatable delegate;

    public PeakUnmodifiable(final Peak delegate) {
        this.delegate = (PeakAnnotatable) delegate;
    }

    @Override
    public PeakUnmodifiable clone() {
        return new PeakUnmodifiable(delegate.clone());
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
    public double getIntensity() {
        return delegate.getIntensity();
    }

    @Override
    public double getIntensityToNoise() {
        return delegate.getIntensityToNoise();
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
        return "PeakUnmodifiable:" + delegate;
    }

}
