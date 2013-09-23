package net.sf.bioutils.proteomics;

import java.util.HashMap;
import java.util.Map;

import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.sample.Sample;

public class MapQuickAcccess {

    private final Map<Peak, Fraction> mapPeakToFraction = new HashMap<Peak, Fraction>();

    public MapQuickAcccess(final Sample sample) {
        for (final Fraction fraction : sample.getFractions()) {
            for (final Peak peak : fraction.getPeaks()) {
                mapPeakToFraction.put(peak, fraction);
            }
        }
    }

    public Map<Peak, Fraction> getMapPeakToFraction() {
        return mapPeakToFraction;
    }

}
