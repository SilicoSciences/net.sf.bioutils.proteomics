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

import net.sf.bioutils.proteomics.feature.Feature;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.equal.Equalator;
import net.sf.kerner.utils.equal.UtilEqual;
import net.sf.kerner.utils.pair.ObjectPair;

/**
 * 
 * TODO description
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
 * <p>
 * <b>Threading:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * Fully thread save since stateless.
 * </pre>
 * 
 * </p>
 * <p>
 * last reviewed: 2014-02-18
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * 
 */
public class EqualatorPeak implements Equalator<Peak> {

    /**
     * Calculates equality based on m/z and fraction index.
     */
    @Override
    public boolean areEqual(final Peak element, final Object obj) {
        if (element == null && obj != null)
            return false;
        if (element != null && obj == null)
            return false;
        if (element == obj)
            return true;
        if (!(obj instanceof Peak))
            return false;
        if (element instanceof Feature && !(obj instanceof Feature))
            return false;
        if (obj instanceof Feature && !(element instanceof Feature))
            return false;
        if (!UtilEqual.areEqual(element.getMz(), ((Peak) obj).getMz()))
            return false;
        if (!UtilEqual.areEqual(element.getFractionIndex(), ((Peak) obj).getFractionIndex()))
            return false;
        return true;
    }

    @Override
    public Boolean transform(final ObjectPair<Peak, Object> element) {
        return Boolean.valueOf(areEqual(element.getFirst(), element.getSecond()));
    }

}
