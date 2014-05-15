package net.sf.bioutils.proteomics;

import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.standard.Standard;

public class FactoryFractionFeatures extends FactoryFractionPeaks {

    @Override
    public synchronized FractionFeatures create() {
        return (FractionFeatures) super.create();
    }

    @Override
    public synchronized FractionFeatures create(final String name) {
        return new FractionFeatures(name);
    }

    @Override
    public synchronized FractionFeatures create(final String name, final List<Peak> peaks,
            final ArrayList<Standard> standards) {
        final FractionFeatures fraction = create(name);
        fraction.setPeaks(peaks);
        fraction.setStandards(standards);
        return fraction;
    }

}
