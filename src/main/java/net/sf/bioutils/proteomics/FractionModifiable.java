/**********************************************************************
 Copyright (c) 2013 Alexander Kerner. All rights reserved.
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
 * Extends {@code Fraction} by adding modifiability.
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
 * last reviewed 2013-03-27
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2013-03-27
 */
public interface FractionModifiable extends Fraction {

    void addPeak(Peak peak);

    void addStandard(Standard standard);

    void removePeak(Peak peak);

    void setName(String name);

    void setPeaks(List<? extends Peak> peaks);

    void setSample(Sample sample);

    void setStandards(List<? extends Standard> standards);

}
