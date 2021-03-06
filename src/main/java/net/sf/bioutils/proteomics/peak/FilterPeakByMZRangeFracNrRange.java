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

import net.sf.jranges.range.doublerange.RangeDouble;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakByMZRangeFracNrRange implements Filter<Peak> {

    private final RangeDouble fracRange;

    private final RangeDouble mzRange;

    public FilterPeakByMZRangeFracNrRange(final RangeDouble fracRange, final RangeDouble mzRange) {
        this.fracRange = fracRange;
        this.mzRange = mzRange;
    }

    @Override
    public boolean filter(final Peak e) {
        return fracRange.includes(e.getFractionIndex()) && mzRange.includes(e.getMz());
    }

}
