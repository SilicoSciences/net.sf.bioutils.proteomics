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
package net.sf.bioutils.proteomics.fraction;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.standard.Standard;

/**
 *
 * Extends {@link Fraction} by adding modifiability.
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
 *
 * </p>
 *
 * <p>
 * last reviewed: 2014-04-15
 * </p>
 *
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 *
 */
public interface FractionModifiable extends Fraction {

    /**
     * Adds given {@link Peak} to this {@code Fraction}. Calls
     * {@link Peak#setFraction(Fraction)} with {@code this} argument on
     * {@link Peak} to add.
     *
     * @param peak
     *            {@link Peak} to add to this {@code Fraction}
     */
    void addPeak(Peak peak);

    void addStandard(Standard standard);

    /**
     * Removes the first occurrence of given {@link Peak} from this
     * {@code Fraction}'s peak list, if it is present. If this {@code Fraction}
     * does not contain given {@link Peak}, peak list it is unchanged.</br> If
     * given {@link Peak} was contained by this {@code Fraction},
     * {@link Peak#setFraction(Fraction)} with {@code null} argument is called.
     *
     * @param peak
     *            {@link Peak} to remove
     * @return {@code true}, if given {@link Peak} was contained by this
     *         {@code Fraction}; {@code false} otherwise
     */
    boolean removePeak(Peak peak);

    void setName(String name);

}
