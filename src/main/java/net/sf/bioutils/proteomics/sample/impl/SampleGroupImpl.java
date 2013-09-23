/**********************************************************************
 Copyright (c) 2012-2013 Alexander Kerner. All rights reserved.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ***********************************************************************/

package net.sf.bioutils.proteomics.sample.impl;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.bioutils.proteomics.sample.SampleGroup;

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
 * last reviewed: 2013-09-23
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * 
 */
public class SampleGroupImpl implements SampleGroup {

    private String name;

    private Set<Sample> samples = new LinkedHashSet<Sample>();

    public SampleGroupImpl(final String name) {
        super();
        this.name = name;
    }

    @Override
    public synchronized void addSample(final Sample sample) {
        samples.add(sample);
    }

    @Override
    public synchronized String getName() {
        return name;
    }

    @Override
    public synchronized Set<Sample> getSamples() {
        return Collections.unmodifiableSet(samples);
    }

    @Override
    public synchronized void removeSample(final Sample sample) {
        samples.remove(sample);
    }

    public synchronized void setName(final String name) {
        this.name = name;
    }

    public synchronized void setSamples(final Set<Sample> samples) {
        this.samples = samples;
    }

    @Override
    public String toString() {
        return name;
    }

}
