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
package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.kerner.utils.collections.filter.Filter;

/**
 * A {@link Filter} that checks weather a given {@link Peak}'s {@code m/z} is
 * within given {@link Range}.
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
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2013-10-18
 */
public class FilterPeakByMzRange implements Filter<Peak> {

    private final DoubleRange range;

    /**
     * Create a new {@code FilterPeakByMZRange}.
     * 
     * @param range
     *            m/z range in which a peak's m/z must be in in order for this
     *            {@code Filter} t accept this peak
     */
    public FilterPeakByMzRange(final DoubleRange range) {
        this.range = range;
    }

    @Override
    public boolean filter(final Peak element) {
        return range.includes(element.getMz());
    }

    @Override
    public String toString() {
        return "massRange=" + range;
    }
}
