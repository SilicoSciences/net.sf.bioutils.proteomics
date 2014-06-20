/*******************************************************************************
 * Copyright 2011-2014 Alexander Kerner. All rights reserved.
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

import net.sf.bioutils.proteomics.annotation.AnnotatableElementProto;
import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.bioutils.proteomics.standard.Standard;

/**
 *
 * Prototype implementation of {@link Peak}.
 *
 * <p>
 * <b>Example:</b><br>
 * </p>
 *
 * <p>
 *
 * <pre>
 * TODO example
 * </pre>
 *
 * </p>
 *
 * <p>
 * <b>Threading:</b> Fully thread save since stateless.
 * </p>
 *
 * <p>
 * last reviewed: 2014-06-16
 * </p>
 *
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 *
 */
public class PeakImpl extends AnnotatableElementProto implements Peak, Standard {

    public final static HashCalculatorPeak HASH_CALCULATOR_PEAK = new HashCalculatorPeak();

    public final static EqualatorPeak EQUALATOR_PEAK = new EqualatorPeak();

    protected Fraction fraction;

    protected double intensity;

    protected double intensityToNoise;

    protected double mz;

    protected String name;

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

    /**
     * Performs a shallow copy of this {@code Peak}.
     */
    @Override
    public synchronized PeakImpl clone() {
        return new PeakImpl(getFraction(), getName(), getMz(), getIntensity(),
                getIntensityToNoise());
    }

    @Override
    public synchronized boolean equals(final Object obj) {
        return EQUALATOR_PEAK.areEqual(this, obj);
    }

    @Override
    public synchronized Fraction getFraction() {
        return fraction;
    }

    @Override
    public synchronized int getFractionIndex() {
        return getFraction().getIndex();
    }

    @Override
    public synchronized String getFractionName() {
        if (getFraction() == null) {
            return null;
        }
        return getFraction().getName();
    }

    @Override
    public synchronized double getIntensity() {
        return intensity;
    }

    @Override
    public synchronized double getIntensityToNoise() {
        return intensityToNoise;
    }

    @Override
    public synchronized double getMz() {
        return mz;
    }

    @Override
    public synchronized String getName() {
        return name;
    }

    @Override
    public synchronized Sample getSample() {
        if (getFraction() == null) {
            return null;
        }
        return getFraction().getSample();
    }

    @Override
    public synchronized String getSampleName() {
        if (getSample() == null) {
            return null;
        }
        return getSample().getName();
    }

    @Override
    public synchronized int hashCode() {
        return HASH_CALCULATOR_PEAK.calculateHash(this);
    }

    @Override
    public synchronized void setFraction(final Fraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public synchronized String toString() {
        return getClass().getSimpleName() + ":mz:" + mz + ",int:" + intensity;
    }

}
