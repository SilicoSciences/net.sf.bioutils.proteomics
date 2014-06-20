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

import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.fraction.FactoryFraction;
import net.sf.bioutils.proteomics.standard.Standard;

public class FactoryFractionPeaks implements FactoryFraction {

    private String name;

    @Override
    public synchronized FractionPeaks create() {
        if (getName() == null) {
            throw new IllegalStateException("set name first");
        }
        return create(getName());
    }

    @Override
    public synchronized FractionPeaks create(final String name) {
        return new FractionPeaks(name);
    }

    @Override
    public synchronized FractionPeaks create(final String name, final List<? extends Peak> peaks,
            final List<? extends Standard> standards) {
        final FractionPeaks fraction = create(name);
        fraction.setPeaks(peaks);
        final List<Standard> ss = new ArrayList<Standard>(standards.size());
        for (final Standard s : standards) {
            ss.add(s.clone());
        }
        fraction.setStandards(ss);
        return fraction;
    }

    @Override
    public synchronized String getName() {
        return name;
    }

    @Override
    public synchronized void setName(final String name) {
        this.name = name;
    }
}
