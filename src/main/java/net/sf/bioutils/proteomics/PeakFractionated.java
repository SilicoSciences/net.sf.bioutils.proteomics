package net.sf.bioutils.proteomics;

public interface PeakFractionated extends Peak {

    Spectrum getSpectra();

    void setSpectra(Spectrum spectra);

}
