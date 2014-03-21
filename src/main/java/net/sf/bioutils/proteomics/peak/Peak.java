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
package net.sf.bioutils.proteomics.peak;

import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.provider.ProviderFractionIndex;
import net.sf.bioutils.proteomics.provider.ProviderIntensity;
import net.sf.bioutils.proteomics.provider.ProviderMz;
import net.sf.bioutils.proteomics.provider.ProviderSample;
import net.sf.bioutils.proteomics.sample.Sample;

public interface Peak extends ProviderIntensity, ProviderMz, ProviderFractionIndex, ProviderSample {

    Peak clone();

    Fraction getFraction();

    /**
     * Shortcut for {@link Peak.getFraction().getIndex()}. </p> Can be helpful
     * for implementations of {@code Peak} which do not have a {@link Fraction}.
     * 
     * @return index of {@link Fraction} which contains this {@code peak}
     */
    @Override
    int getFractionIndex();

    String getName();

    /**
     * Shortcut for {@link Peak.getFraction().getSample()}. </p> Can be helpful
     * for implementations of {@code Peak} which do not have a {@link Fraction}.
     * 
     * @return {@link Sample} which is assigned to this {@code peak}
     */
    @Override
    Sample getSample();

    /**
     * Shortcut for {@link Peak.getFraction().getSample().getName()}. </p> Can
     * be helpful for implementations of {@code Peak} which do not have a
     * {@link Fraction} or {@link Sample}.
     * 
     * @return {@link Sample} which is assigned to this {@code peak}
     */
    String getSampleName();

    void setFraction(Fraction fraction);

}
