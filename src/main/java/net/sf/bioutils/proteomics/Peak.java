/**********************************************************************
 Copyright (c) 2013 Alexander Kerner. All rights reserved.
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

package net.sf.bioutils.proteomics;

/**
 * TODO description
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
 * last reviewed 2013-08-08
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2013-09-19
 */
public interface Peak {

    Peak clone();

    Fraction getFraction();

    /**
     * Shortcut for {@link Peak.getFraction().getIndex()}. </p> Can be helpful
     * for implementations of {@code Peak} which do not have a {@link Fraction}.
     * 
     * @return index of {@link Fraction} which contains this {@code peak}
     */
    int getFractionIndex();

    double getIntensity();

    double getIntensityToNoise();

    double getMz();

    double getMz(MassUnit unit);

    String getName();

    /**
     * Shortcut for {@link Peak.getFraction().getSample()}. </p> Can be helpful
     * for implementations of {@code Peak} which do not have a {@link Fraction}.
     * 
     * @return {@link Sample} which is assigned to this {@code peak}
     */
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
