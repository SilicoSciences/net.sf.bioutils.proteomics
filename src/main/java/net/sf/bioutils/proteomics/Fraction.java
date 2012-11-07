/**********************************************************************
 Copyright (c) 2012 Alexander Kerner. All rights reserved.
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

import java.util.List;

/**
 * A {@code Fraction} is a collection of {@link Peak Peaks} eluting at the same time.
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
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2012-10-19
 */
public interface Fraction {

    /**
     * Retrieve name of this fraction.
     * 
     * @return name of this fraction
     */
    String getName();

    /**
     * Retrieve this fraction's {@link Peak Peaks}
     * 
     * @return this fraction's {@link Peak Peaks}
     */
    List<Peak> getPeaks();

    Sample getSample();

    /**
     * Retrieve number of {@link Peak Peaks} in this fraction. </p> <b>Note:</> {@code null} peaks are not counted!
     * 
     * @return number of {@link Peak Peaks} in this fraction
     */
    int getSize();

    /**
     * Retrieve this fraction's {@link Standard Standards}.
     * 
     * @return this fraction's {@link Standard Standards}
     */
    List<Standard> getStandards();

    /**
     * Check, weather this fraction is empty {@code getSize() == 0}.
     * 
     * @return {@code true}, if number of {@link Peak Peaks} in this fraction is {@code 0}; {@code false} otherwise
     */
    boolean isEmpty();

    void setSample(Sample sample);

}
