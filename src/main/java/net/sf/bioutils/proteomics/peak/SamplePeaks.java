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
package net.sf.bioutils.proteomics.peak;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.sf.bioutils.proteomics.User;
import net.sf.bioutils.proteomics.UtilFraction;
import net.sf.bioutils.proteomics.fraction.FactoryFraction;
import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.fraction.FractionModifiable;
import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.bioutils.proteomics.sample.SampleModifiable;
import net.sf.bioutils.proteomics.sample.impl.EqualatorSample;
import net.sf.bioutils.proteomics.sample.impl.HashCalculatorSample;
import net.sf.kerner.utils.UtilString;
import net.sf.kerner.utils.collections.list.UtilList;
import net.sf.kerner.utils.exception.ExceptionReadOnly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation for {@link Sample}, which expects to have fractions of type
 * {@link FractionPeaks}.
 * <p>
 * <b>Example:</b><br>
 * </p>
 * <p>
 *
 * <pre>
 * TODO example
 * </pre>
 *
 * </p>
 * <p>
 * last reviewed 2014-02-18
 * </p>
 *
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2014-02-18
 */
public class SamplePeaks implements SampleModifiable {

    private final static Logger log = LoggerFactory.getLogger(SamplePeaks.class);

    static void addPeak(final Sample sample, final Peak peak, final FactoryFraction factoryFraction) {
        addPeaks(sample, Arrays.asList(peak), factoryFraction);

    }

    /**
     * Adds given {@link Peak peaks} to given {@link Sample sample}.
     *
     *
     * <p>
     * last reviewed: 2013-08-08
     * </p>
     *
     * @param sample
     *            {@link Sample sample} to add {@link Peak peaks} to
     * @param peaksToAdd
     *            {@link Peak peaks} to add to given {@link Sample sample}
     *
     */
    static void addPeaks(final Sample sample, final Collection<? extends Peak> peaksToAdd,
            final FactoryFraction factoryFraction) {
        for (final Peak p : peaksToAdd) {

            final int index;
            index = p.getFractionIndex();
            if (index < 0) {
                throw new IllegalArgumentException();
            }
            // get fraction via index, workaround for fraction does not
            // override
            // hashcode and/or equals
            // FactoryFraction not needed, fraction must exist?
            final Fraction fractionFound = getFraction(sample, index, factoryFraction);

            if (fractionFound instanceof FractionModifiable) {
                ((FractionModifiable) fractionFound).addPeak(p);
            } else {
                throw new ExceptionReadOnly("Cannot modify fraction " + fractionFound);
            }
        }
    }

    /**
     * Retrieves {@link Fraction} at {@code index} in {@code sample}. If there
     * is no fraction at given index, provided {@link FactoryFraction} is used
     * to create one. This newly created fraction is added to the sample
     * Immediately.
     *
     * @param sample
     *            {@link Sample} to retrieve {@link Fraction} from
     * @param index
     *            fraction index
     * @param factoryFraction
     *            {@link FactoryFraction} which is used to create a new
     *            {@link Fraction}
     * @return {@link Fraction} at given index, or newly created
     *         {@link Fraction}
     * @throws IllegalArgumentException
     *             if {@code index < 0}
     */
    public static Fraction getFraction(final Sample sample, final int index,
            final FactoryFraction factoryFraction) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("invalid fraction index " + index);
        }
        if (sample.getFractions().size() <= index) {
            final List<Fraction> fractions = UtilList.newList(sample.getFractions());
            factoryFraction.setName("feature-fraction");
            UtilList.fill(fractions, index + 1, factoryFraction);
            sample.setFractions(fractions);
        }
        final Fraction result = sample.getFractions().get(index);
        if (result.getIndex() != index) {
            throw new RuntimeException();
        }
        return result;
    }

    static void removePeak(final Sample sample, final Peak peak) {

        final Fraction f = peak.getFraction();

        // get fration via index, workaround for fraction does not override
        // hashcode and/or equals

        final Fraction fractionFound = sample.getFractions().get(f.getIndex());
        if (fractionFound instanceof FractionModifiable) {
            ((FractionModifiable) fractionFound).removePeak(peak);
        } else {
            if (log.isWarnEnabled()) {
                log.warn("cannot remove peak to fraction " + fractionFound);
            }
        }
    }

    static void removePeaks(final Sample selectedSample,
            final Collection<? extends Peak> peaksToRemove) {
        for (final Peak p : peaksToRemove) {
            removePeak(selectedSample, p);
        }
    }

    private final FactoryFraction factoryFraction = new FactoryFractionPeaks();

    private List<Fraction> fractions = UtilList.newList();

    private Properties properties = new Properties();

    private String name;

    private User user;

    public SamplePeaks(final Sample sample) {
        this(sample, sample.getName());
    }

    public SamplePeaks(final Sample sample, final String newName) {
        this(newName, sample.getUser());
        for (final Peak p : sample.getPeaks()) {
            addPeak(p.clone());
        }
        getProperties().putAll(sample.getProperties());
    }

    public SamplePeaks(final String name) {
        this(name, null);
    }

    public SamplePeaks(final String name, final User user) {
        this.user = user;
        this.name = name;
    }

    @Override
    public synchronized void addFraction(final Fraction fraction) {
        // super.addFraction(fraction);
        checkFraction(fraction);
        fractions.add(fraction);
    }

    @Override
    public synchronized void addPeak(final Peak peak) {
        // super.addPeak(peak);
        addPeak(this, peak, getFactoryFraction());
    }

    @Override
    public synchronized void addPeaks(final Collection<? extends Peak> peaks) {
        // super.addPeaks(peaks);
        addPeaks(this, peaks, getFactoryFraction());
    }

    protected void checkFraction(final Fraction f) {
        // if (!(f instanceof FractionPeaks) && !(f instanceof
        // FractionTestable)) {
        // throw new IllegalArgumentException("invalid fraction " +
        // f.getClass().getSimpleName());
        // }
        f.setSample(this);
    }

    @Override
    public synchronized SamplePeaks clone() {
        return new SamplePeaks(this);
    }

    @Override
    public Sample clone(final String newName) {
        return new SamplePeaks(this, newName);
    }

    @Override
    public SamplePeaks cloneWOFractions() {
        final SamplePeaks result = new SamplePeaks(getName(), getUser());
        result.setProperties(getProperties());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        return new EqualatorSample().areEqual(this, obj);
    }

    protected FactoryFraction getFactoryFraction() {
        return factoryFraction;
    }

    /**
     * Returns a unmodifiable {@code List} of this {@code Sample's}
     * {@link FractionPeaks fractions}.
     */
    @Override
    public List<Fraction> getFractions() {
        return Collections.unmodifiableList(fractions);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Peak> getPeaks() {
        return UtilFraction.getPeaks(fractions);
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public synchronized int getSize() {
        int result = 0;
        for (final Fraction f : fractions) {
            result += f.getSize();
        }
        return result;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public int hashCode() {
        return new HashCalculatorSample().calculateHash(this);
    }

    @Override
    public Iterator<Fraction> iterator() {
        return getFractions().iterator();
    }

    @Override
    public synchronized void removePeak(final Peak peak) {
        // super.removePeak(peak);
        removePeak(this, peak);
    }

    @Override
    public synchronized void removePeaks(final Collection<? extends Peak> peaks) {
        // super.removePeaks(peaks);
        removePeaks(this, peaks);
    }

    @Override
    public synchronized void setFractions(final List<? extends Fraction> fractions) {
        for (final Fraction f : fractions) {
            checkFraction(f);
        }
        // cast is save since all fractions have been checked on type
        this.fractions = UtilList.cast(fractions);
        // for (final Fraction f : fractions) {
        // super.addFraction(f);
        // }
    }

    /**
     * Sets this {@code Sample's} name.
     *
     * @throws IllegalArgumentException
     *             if given name is {@code null} or empty.
     */
    @Override
    public void setName(final String name) {
        if (UtilString.emptyString(name)) {
            throw new IllegalArgumentException("invalid sample name");
        }
        this.name = name;
    }

    @Override
    public void setProperties(final Properties properties) {
        this.properties = properties;
    }

    @Override
    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return getName();
    }
}
