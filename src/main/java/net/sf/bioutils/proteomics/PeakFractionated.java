package net.sf.bioutils.proteomics;

public interface PeakFractionated extends Peak {

    Spectrum getSpectrum();

    void setSpectra(Spectrum spectra);

}
