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
package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterPeakBySignalToNoise implements Filter<Peak> {

    public static enum Type {
        ABOVE, BELOW
    }

    private final double snRatio;

    private final Type type;

    public FilterPeakBySignalToNoise(final double snRatio, final Type type) {
        super();
        this.snRatio = snRatio;
        this.type = type;
    }

    @Override
    public boolean filter(final Peak e) {
        switch (type) {
            case BELOW:
                return e.getIntensityToNoise() < snRatio;
            case ABOVE:
                return e.getIntensityToNoise() > snRatio;
            default:
                throw new RuntimeException("unknown type " + type);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + type + " " + snRatio;
    }

}
