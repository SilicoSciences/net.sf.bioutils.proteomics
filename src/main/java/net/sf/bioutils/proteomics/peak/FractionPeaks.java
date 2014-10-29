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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.sf.bioutils.proteomics.feature.Feature;
import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.fraction.FractionModifiable;
import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.bioutils.proteomics.standard.Standard;
import net.sf.kerner.utils.Util;
import net.sf.kerner.utils.collections.list.UtilList;
import net.sf.kerner.utils.exception.ExceptionReadOnly;

public class FractionPeaks implements Fraction, FractionModifiable {

    protected transient int cacheIndex = -1;

    protected final String name;

    protected List<Peak> peaks = new ArrayList<Peak>(0);

    protected Sample sample;

    protected LinkedHashSet<Standard> standards = new LinkedHashSet<Standard>(0);

    private transient String cacheSampleName;

    public FractionPeaks() {
        name = null;
    }

    public FractionPeaks(final String name) {
        this.name = name;
    }

    @Override
    public synchronized void addPeak(final Peak peak) throws IllegalArgumentException {
        checkPeak(peak);
        setFraction(peak);
        peaks.add(peak);
    }

    @Override
    public synchronized void addStandard(final Standard standard) throws IllegalArgumentException {
        checkPeak(standard);
        setFraction(standard);
        standards.add(standard);
    }

    protected void checkPeak(final Peak p) throws IllegalArgumentException {
        Util.checkForNull(p);
        // if (p instanceof Feature) {
        // throw new IllegalArgumentException("we dont want features");
        // }
    }

    @Override
    public synchronized FractionPeaks clone() {
        final FractionPeaks result = getInstance(getName());
        result.setSample(getSample());
        // TODO: clone standards too!
        // result.setStandards(UtilList.clone(getStandards()));
        result.setPeaks(UtilList.clone(getPeaks()));
        return result;
    }

    @Override
    public synchronized FractionPeaks cloneWOPeaks() {
        final FractionPeaks result = getInstance(getName());
        result.setSample(getSample());
        // TODO: clone standards too!
        // result.setStandards(UtilList.clone(getStandards()));
        // result.setPeaks(UtilPeak.clone(getPeaks()));
        return result;
    }

    @Override
    public synchronized boolean equals(final Object obj) {
        return this == obj;
        // if (this == obj)
        // return true;
        // if (obj == null)
        // return false;
        // if (!(obj instanceof FractionPeaks))
        // return false;
        // final FractionPeaks other = (FractionPeaks) obj;
        // if (peaks == null) {
        // if (other.peaks != null)
        // return false;
        // } else if (!peaks.equals(other.peaks))
        // return false;
        // if (standards == null) {
        // if (other.standards != null)
        // return false;
        // } else if (!standards.equals(other.standards))
        // return false;
        // return true;
    }

    @Override
    public synchronized int getIndex() {
        if (getSample() == null) {
            return -1;
        }
        int result = cacheIndex;
        if (result < 0) {
            result = getSample().getFractions().indexOf(this);
            cacheIndex = result;
        }
        return result;
    }

    protected FractionPeaks getInstance(final String name) {
        return new FractionPeaks(name);
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * @return an unmodifiable {@link List} of this {@code Fraction's}
     *         {@link Peak Peaks}.
     */
    @Override
    public synchronized List<Peak> getPeaks() {
        return Collections.unmodifiableList(peaks);
    }

    /**
     * @return direct reference to this {@code Fraction}'s {@link Sample}.
     */
    @Override
    public Sample getSample() {
        return sample;
    }

    @Override
    public synchronized String getSampleName() {
        if (getSample() == null) {
            return null;
        }
        String result = cacheSampleName;
        if (result == null) {
            result = getSample().getName();
            cacheSampleName = result;
        }
        return result;
    }

    /**
     * @return number of {@link Peak peaks} in this {@code Fraction}
     */
    @Override
    public synchronized int getSize() {
        return peaks.size();
    }

    /**
     * @return unmodifiable {@link List} of this {@code Fraction}'s
     *         {@link Standard standards}.
     */
    @Override
    public synchronized Set<Standard> getStandards() {
        return Collections.unmodifiableSet(standards);
    }

    @Override
    public synchronized int hashCode() {
        // final int prime = 31;
        // int result = 1;
        // result = prime * result + ((peaks == null) ? 0 : peaks.hashCode());
        // result = prime * result + ((standards == null) ? 0 :
        // standards.hashCode());
        // return result;
        return super.hashCode();
    }

    @Override
    public synchronized boolean isEmpty() {
        return (getSize() == 0);
    }

    @Override
    public Iterator<Peak> iterator() {
        return getPeaks().iterator();
    }

    @Override
    public synchronized boolean removePeak(final Peak peak) {
        final boolean result = peaks.remove(peak);
        if (result)
            peak.setFraction(null);
        return result;
    }

    private void setFraction(final Peak p) {
        p.setFraction(this);
        if (p.getName() != null && p instanceof PeakModifiable) {
            final String[] split = p.getName().split("-");
            final String newName = getName() + "-" + split[split.length - 1];
            ((PeakModifiable) p).setName(newName);
        }
    }

    /**
     * @throws ExceptionReadOnly
     *             always
     */
    @Override
    public synchronized void setName(final String name) {
        throw new ExceptionReadOnly();
    }

    /**
     * @throws IllegalArgumentException
     *             if {@code p} is instance of {@link Feature}
     */
    @Override
    public synchronized void setPeaks(final Collection<? extends Peak> peaks) {
        this.peaks.clear();
        for (final Peak p : peaks) {
            checkPeak(p);
            setFraction(p);
            addPeak(p);
        }
    }

    @Override
    public synchronized void setSample(final Sample sample) {
        this.sample = sample;
        cacheSampleName = null;
    }

    /**
     * @throws IllegalArgumentException
     *             if {@code p} is instance of {@link Feature}
     */
    @Override
    public synchronized void setStandards(final Collection<? extends Standard> standards) {
        for (final Standard s : standards) {
            checkPeak(s);
            setFraction(s);
        }
        for (final Standard s : standards) {
            addStandard(s);
        }
    }

    @Override
    public synchronized String toString() {
        return getName() + " " + getSampleName();
    }

}
