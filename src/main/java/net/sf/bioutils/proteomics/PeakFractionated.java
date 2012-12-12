package net.sf.bioutils.proteomics;

public interface PeakFractionated extends Peak {

    Spectra getSpectra();

    void setSpectra(Spectra spectra);

}
