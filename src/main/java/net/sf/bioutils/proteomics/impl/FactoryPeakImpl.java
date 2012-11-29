package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.factory.FactoryPeak;

public class FactoryPeakImpl implements FactoryPeak {

    @Override
    public Peak create(final String name, final double mz, final double intensity, final double snRatio) {
        return new PeakImpl(name, mz, intensity, snRatio);
    }

}
