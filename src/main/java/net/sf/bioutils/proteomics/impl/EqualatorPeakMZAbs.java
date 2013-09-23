package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.Equalator;
import net.sf.kerner.utils.math.UtilMath;

public class EqualatorPeakMZAbs implements Equalator<Peak> {

    private final int accuracy;

    public EqualatorPeakMZAbs(final int accuracy) {
        super();
        this.accuracy = accuracy;
    }

    public boolean areEqual(final Peak o1, final Peak o2) {
        return Double.valueOf(UtilMath.round(o1.getMz(), accuracy)).equals(
                Double.valueOf(UtilMath.round(o2.getMz(), accuracy)));
    }
}
