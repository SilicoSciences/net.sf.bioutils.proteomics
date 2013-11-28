package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.provider.ProviderMz;
import net.sf.kerner.utils.equal.EqualatorAbstract;
import net.sf.kerner.utils.math.UtilMath;

public class EqualatorPeakMZAbs extends EqualatorAbstract<Peak> {

    private final int accuracy;

    public EqualatorPeakMZAbs(final int accuracy) {
        super();
        this.accuracy = accuracy;
    }

    @Override
    public boolean areEqual(final Peak o1, final Object o2) {
        return Double.valueOf(UtilMath.round(o1.getMz(), accuracy)).equals(
                Double.valueOf(UtilMath.round(((ProviderMz) o2).getMz(), accuracy)));
    }
}
