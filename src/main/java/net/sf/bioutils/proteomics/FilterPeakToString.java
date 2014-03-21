/*******************************************************************************
 * Copyright 2011-2014 Alexander Kerner
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
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakToString implements Filter<Peak> {

    private final String text;

    public FilterPeakToString(final String text) {
        this.text = text;
    }

    @Override
    public boolean filter(final Peak e) {
        final String toString = e.toString();
        final boolean matches = toString.replaceAll("\n", " ").matches(".*(?i)" + text + ".*");
        return matches;
    }

}
