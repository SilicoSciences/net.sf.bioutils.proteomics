package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.Fraction;
import net.sf.bioutils.proteomics.MassUnit;
import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.Sample;
import net.sf.bioutils.proteomics.Standard;
import net.sf.kerner.utils.impl.util.Util;

public class PeakImpl implements Peak, Standard {

    public final static MassUnit DEFAULT_UNIT = MassUnit.DALTON;

    private Fraction fraction = null;

    private final double intensity;

    private final double intensityToNoise;

    private final double mz;

    private final String name;

    public PeakImpl(final double mz, final double intensity) {
        this(null, null, mz, intensity, -1);
    }

    public PeakImpl(final Fraction fraction, final String name, final double mz, final double intensity,
            final double intensityToNoise) {
        super();
        this.fraction = fraction;
        this.intensity = intensity;
        this.intensityToNoise = intensityToNoise;
        this.mz = mz;
        this.name = name;
    }

    public PeakImpl(final String name, final double mz, final double intensity, final double intensityToNoise) {
        this(null, name, mz, intensity, intensityToNoise);
    }

    @Override
    public PeakImpl clone() {
        return new PeakImpl(null, getName(), getMz(), getIntensity(), getIntensityToNoise());
    }

    @Override
    public boolean equals(final Object obj) {
        return Util.equalsOnHashCode(this, obj);
    }

    @Override
    public Fraction getFraction() {
        return fraction;
    }

    @Override
    public int getFractionIndex() {
        return getFraction().getIndex();
    }

    @Override
    public double getIntensity() {
        return intensity;
    }

    @Override
    public double getIntensityToNoise() {
        return intensityToNoise;
    }

    @Override
    public double getMz() {
        return mz;
    }

    @Override
    public double getMz(final MassUnit unit) {
        return DEFAULT_UNIT.convert(mz, unit);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Sample getSample() {
        return getFraction().getSample();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(intensity);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(intensityToNoise);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mz);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public void setFraction(final Fraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public String toString() {
        return "mz:" + mz + ",int:" + intensity;
    }

}
