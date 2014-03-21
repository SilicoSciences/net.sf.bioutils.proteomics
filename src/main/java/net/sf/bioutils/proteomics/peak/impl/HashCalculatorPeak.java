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
package net.sf.bioutils.proteomics.peak.impl;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.hash.HashCalculatorAbstract;

public class HashCalculatorPeak extends HashCalculatorAbstract<Peak> {

    /**
     * Calculates hash code based on m/z and fraction index.
     */
    @Override
    public int calculateHash(final Peak element) {
        synchronized (element) {
            int result = 95419;
            final int prime = 74551;
            long temp;
            temp = Double.doubleToLongBits(element.getMz());
            result = prime * result + (int) (temp ^ (temp >>> 32));
            result = prime * result + element.getFractionIndex();
            // if (element instanceof Feature) {
            // result = prime * result + ((Feature) element).getFirstIndex();
            // result = prime * result + ((Feature) element).getLastIndex();
            // }
            return result;
        }
    }

    @Override
    public Integer transform(final Peak element) {
        return Integer.valueOf(calculateHash(element));
    }

}
