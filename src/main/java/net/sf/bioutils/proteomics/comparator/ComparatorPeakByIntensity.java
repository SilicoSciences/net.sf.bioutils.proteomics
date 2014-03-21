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
package net.sf.bioutils.proteomics.comparator;

import java.util.Comparator;

import net.sf.bioutils.proteomics.peak.Peak;

public class ComparatorPeakByIntensity implements Comparator<Peak> {

    private final static ComparatorIntensity COMPARATOR_INTENSITY = new ComparatorIntensity();

    @Override
    public int compare(final Peak o1, final Peak o2) {
        return COMPARATOR_INTENSITY.compare(o1, o2);
    }

}
