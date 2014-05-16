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

import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.provider.ProviderFractionIndex;
import net.sf.bioutils.proteomics.provider.ProviderIntensity;
import net.sf.bioutils.proteomics.provider.ProviderMz;
import net.sf.bioutils.proteomics.provider.ProviderSample;
import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.kerner.utils.Cloneable;

/**
 *
 * A {@code Peak} represents a MS signal which has at least two properties:
 * <ol>
 * <li>a mass-to-charge-ratio</li>
 * <li>and a signal intensity</li>
 * </ol>
 * A {@code Peak} is usually also associated to a {@link Sample} and, if it was
 * detected during a MALDI-MS experiment, also a {@link Fraction}.
 *
 * <p>
 * <b>Example:</b><br>
 *
 * </p>
 * <p>
 *
 * <pre>
 * TODO example
 * </pre>
 * <p>
 * last reviewed: 2014-04-09
 * </p>
 *
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 *
 */
public interface Peak extends ProviderIntensity, ProviderMz, ProviderFractionIndex, ProviderSample,
        Cloneable<Peak> {

    /**
     * Creates a clone of this {@code Peak}.</br> <b>Note:</b></br>
     * Bidirectional relationship to {@link Fraction} and its {@link Sample}:
     * When cloning {@link Fraction} or taking over its direct reference,
     * {@link Fraction} - {@code Peak} relationship is broken: The cloned
     * {@code Peak} will have a reference to a {@link Fraction} and its
     * {@link Sample}, but this {@link Fraction} does not know about the newly
     * cloned {@code Peak}. The cloned {@code Peak} will therefore not be
     * accessible via {@link Fraction} and its {@link Sample}!
     */
    @Override
    Peak clone();

    /**
     *
     * @return {@link Fraction}, which contains this {@code Peak}; or
     *         {@code null} if this {@code Peak} is not contained in any
     *         {@link Fraction}
     */
    Fraction getFraction();

    /**
     * Shortcut for {@link Peak.getFraction().getIndex()}. </br> Can be helpful
     * for implementations of {@code Peak} which do not have a {@link Fraction}.
     *
     * @return index of {@link Fraction} which contains this {@code Peak}
     */
    @Override
    int getFractionIndex();

    String getName();

    /**
     * Shortcut for {@link Peak.getFraction().getSample()}. </br> Can be helpful
     * for implementations of {@code Peak} which do not have a {@link Fraction}.
     *
     * @return {@link Sample} which contains this {@code Peak}
     */
    @Override
    Sample getSample();

    /**
     * Shortcut for {@link Peak.getFraction().getSample().getName()}. </br> Can
     * be helpful for implementations of {@code Peak} which do not have a
     * {@link Fraction} or {@link Sample}.
     *
     * @return {@link Sample} which is assigned to this {@code peak}
     */
    @Override
    String getSampleName();

    /**
     * Sets the {@link Fraction} which contains this {@code Peak}. </br>
     * Typically, this method is called by {@link Fraction} itself!
     *
     * @param fraction
     *            {@link Fraction}, which contains this {@code Peak}
     */
    void setFraction(Fraction fraction);

}
