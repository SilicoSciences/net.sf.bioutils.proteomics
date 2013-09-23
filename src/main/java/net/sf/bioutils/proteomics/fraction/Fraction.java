/**********************************************************************
 Copyright (c) 2012-2013 Alexander Kerner. All rights reserved.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ***********************************************************************/

package net.sf.bioutils.proteomics.fraction;

import java.util.Iterator;
import java.util.List;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.bioutils.proteomics.standard.Standard;
import net.sf.kerner.utils.Cloneable;

/**
 * A {@code Fraction} is a collection of {@link Peak Peaks} eluting at the same
 * time.
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
 * last reviewed 2013-09-23
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * 
 */
public interface Fraction extends Iterable<Peak>, Cloneable<Fraction> {

    /**
     * Returns the index of this fraction in {@link Sample#getFractions()}.
     * 
     * @return this fraction's index
     */
    int getIndex();

    /**
     * Returns the name of this fraction.
     * 
     * @return name of this fraction
     */
    String getName();

    /**
     * Returns this fraction's {@link Peak Peaks}
     * 
     * @return this fraction's {@link Peak Peaks}
     */
    List<Peak> getPeaks();

    /**
     * Returns the {@link Sample} which this fraction is in.
     * 
     * @return this fraction's sample
     */
    Sample getSample();

    /**
     * Shortcut for {@link getSample().getName()}. </p> Can be helpful for
     * implementations of {@code Fraction} which do not have a {@link Sample}.
     * 
     * @return {@link Sample} which is assigned to this {@code peak}
     */
    String getSampleName();

    /**
     * Get number of {@link Peak Peaks} in this fraction.
     * 
     * @return number of {@link Peak Peaks} in this fraction
     */
    int getSize();

    /**
     * Get this fraction's {@link Standard Standards}.
     * 
     * @return this fraction's {@link Standard Standards}
     */
    List<Standard> getStandards();

    /**
     * Check weather this fraction is empty {@code getSize() == 0}.
     * 
     * @return {@code true}, if number of {@link Peak Peaks} in this fraction is
     *         {@code 0}; {@code false} otherwise
     */
    boolean isEmpty();

    @Override
    public Iterator<Peak> iterator();

    void setPeaks(List<? extends Peak> peaks);

    void setSample(Sample sample);

    void setStandards(List<? extends Standard> standards);

}
