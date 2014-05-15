package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.feature.Feature;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.Util;

public class FractionFeatures extends FractionPeaks {

    public FractionFeatures(final String name) {
        super(name);
    }

    /**
     * @throws IllegalArgumentException
     *             if {@code p} is not instance of {@link Feature}
     */
    @Override
    protected void checkPeak(final Peak p) {
        Util.checkForNull(p);
        if (!(p instanceof Feature)) {
            throw new IllegalArgumentException("wrong peak type (instance of feature expected) "
                    + p.getClass().getSimpleName());
        }
    }

    @Override
    public synchronized FractionFeatures clone() {
        return (FractionFeatures) super.clone();
    }

    @Override
    public synchronized FractionFeatures cloneWOPeaks() {
        return (FractionFeatures) super.cloneWOPeaks();
    }

    @Override
    protected synchronized FractionFeatures getInstance(final String name) {
        return new FractionFeatures(name);
    }
}
