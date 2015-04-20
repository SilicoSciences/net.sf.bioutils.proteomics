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

import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.doublerange.impl.DummyDoubleRange;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakByIntensity implements Filter<Peak> {

    public static enum TYPE {
        EXACT, MIN, MAX
    }

    private final DoubleRange range;

    public FilterPeakByIntensity(final double intensity, final TYPE type) {
        switch (type) {
            case EXACT:
                range = new DummyDoubleRange(intensity, intensity);
                break;
            case MIN:
                range = new DummyDoubleRange(intensity, Double.MAX_VALUE);
                break;
            case MAX:
                range = new DummyDoubleRange(Double.MIN_VALUE, intensity);
                break;
            default:
                throw new IllegalArgumentException("unknown type " + type);
        }

    }

    public FilterPeakByIntensity(final DoubleRange range) {
        this.range = range;
    }

    @Override
    public boolean filter(final Peak element) {
        return range.includes(element.getIntensity());
    }

    @Override
    public String toString() {
        return "Int.range=" + range;
    }

}
