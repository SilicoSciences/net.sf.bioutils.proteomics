/*******************************************************************************
 * Copyright (c) 2011-2014 Alexander Kerner. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sf.bioutils.proteomics.peak.impl;

import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.bioutils.proteomics.standard.Standard;

public class PeakImpl implements Peak, Standard {

    private Fraction fraction;

    private final double intensity;

    private final double intensityToNoise;

    private final double mz;

    private final String name;

    public PeakImpl(final double mz, final double intensity) {
        this(null, null, mz, intensity, -1);
    }

    public PeakImpl(final Fraction fraction, final String name, final double mz,
            final double intensity, final double intensityToNoise) {
        super();
        this.fraction = fraction;
        this.intensity = intensity;
        this.intensityToNoise = intensityToNoise;
        this.mz = mz;
        this.name = name;
    }

    public PeakImpl(final String name, final double mz, final double intensity,
            final double intensityToNoise) {
        this(null, name, mz, intensity, intensityToNoise);
    }

    @Override
    public PeakImpl clone() {
        return new PeakImpl(getFraction(), getName(), getMz(), getIntensity(),
                getIntensityToNoise());
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof PeakImpl))
            return false;
        final PeakImpl other = (PeakImpl) obj;
        if (fraction == null) {
            if (other.fraction != null)
                return false;
        } else if (!fraction.equals(other.fraction))
            return false;
        if (Double.doubleToLongBits(mz) != Double.doubleToLongBits(other.mz))
            return false;
        return true;
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
    public String getName() {
        return name;
    }

    @Override
    public Sample getSample() {
        return getFraction().getSample();
    }

    @Override
    public String getSampleName() {
        return getSample().getName();
    }

    @Override
    public synchronized int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fraction == null) ? 0 : fraction.hashCode());
        long temp;
        temp = Double.doubleToLongBits(mz);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
