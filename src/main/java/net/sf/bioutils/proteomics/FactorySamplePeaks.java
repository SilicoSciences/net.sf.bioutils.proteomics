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

import net.sf.bioutils.proteomics.sample.FactorySample;
import net.sf.bioutils.proteomics.sample.Sample;

public class FactorySamplePeaks implements FactorySample {

    private String name;

    @Override
    public SamplePeaks create() {
        return new SamplePeaks(name);
    }

    @Override
    public Sample create(final String name) {
        return new SamplePeaks(name, null);
    }

    @Override
    public Sample create(final String name, final User user) {
        return new SamplePeaks(name, user);
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(final String name) {
        this.name = name;
    }

}
