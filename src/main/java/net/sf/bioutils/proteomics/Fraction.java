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

package net.sf.bioutils.proteomics;

import java.util.Iterator;
import java.util.List;

/**
 * A {@code Fraction} is a collection of {@link Peak Peaks} eluting at the same
 * time.
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
 * <p>
 * last reviewed 2011-11-10
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2013-04-04
 */
public interface Fraction extends Iterable<Peak> {

    Fraction clone();

    int getIndex();

    /**
     * Get name of this fraction.
     * 
     * @return name of this fraction
     */
    String getName();

    /**
     * Get this fraction's {@link Peak Peaks}
     * 
     * @return this fraction's {@link Peak Peaks}
     */
    List<Peak> getPeaks();

    Sample getSample();

    /**
     * Get number of {@link Peak Peaks} in this fraction.
     * 
     * @return number of {@link Peak Peaks} in this fraction
     */
    int getSize();

    /**
     * Get this fraction's {@link Standard Standards}.
     * 
     * @return this fraction's {@link Standard Standards}
     */
    List<Standard> getStandards();

    /**
     * Check weather this fraction is empty {@code getSize() == 0}.
     * 
     * @return {@code true}, if number of {@link Peak Peaks} in this fraction is
     *         {@code 0}; {@code false} otherwise
     */
    boolean isEmpty();

    // TODO: move to FractionModifiable

    public Iterator<Peak> iterator();

    void setPeaks(List<? extends Peak> peaks);

    void setSample(Sample sample);

    void setStandards(List<? extends Standard> standards);

}
