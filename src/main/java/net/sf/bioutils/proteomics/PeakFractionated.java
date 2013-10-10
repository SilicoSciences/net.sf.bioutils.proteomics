package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.peak.Peak;

public interface PeakFractionated extends Peak {

    Spectrum getSpectrum();

    void setSpectrum(Spectrum spectra);

}
