package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.MassUnit;
import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.Standard;
import net.sf.kerner.utils.impl.util.Util;

public class PeakImpl implements Peak, Standard {

    public final static MassUnit DEFAULT_UNIT = MassUnit.DALTON;

    private final double intensity;

    private final double intensityToNoise;

    private final double mz;

    private final String name;

    private final double signalToNoiseRatio;

    public PeakImpl(final double mz, final double intensity) {
        this(mz, intensity, -1, null, -1);
    }

    public PeakImpl(final double mz, final double intensity, final double signalToNoiseRatio) {
        this(mz, intensity, -1, null, signalToNoiseRatio);
    }

    public PeakImpl(final double mz, final double intensity, final double intensityToNoise, final String name,
            final double signalToNoiseRatio) {
        super();
        this.intensity = intensity;
        this.intensityToNoise = intensityToNoise;
        this.mz = mz;
        this.name = name;
        this.signalToNoiseRatio = signalToNoiseRatio;
    }

    public PeakImpl(final double mz, final double intensity, final String name, final double signalToNoiseRatio) {
        this(intensity, -1, mz, name, signalToNoiseRatio);
    }

    @Override
    public boolean equals(final Object obj) {
        return Util.equalsOnHashCode(this, obj);
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
    public double getSignalToNoiseRatio() {
        return signalToNoiseRatio;
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
        temp = Double.doubleToLongBits(signalToNoiseRatio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "mz:" + mz + ",int:" + intensity;
    }

}
