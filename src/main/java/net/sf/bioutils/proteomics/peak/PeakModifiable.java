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

/**
 *
 * Extends {@link Peak} by modifiability.
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
 *
 * </p>
 * <p>
 * last reviewed: 2014-05-16
 * </p>
 *
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 *
 */
public interface PeakModifiable extends Peak {

    /**
     * Sets this Peak's intensity to given intensity.
     *
     * <p>
     * <b>Note:</b> A new intensity may change this Peak's hash code and
     * equality!
     * </p>
     *
     * @param intensity
     *            new intensity
     */
    void setIntensity(double intensity);

    void setIntensityToNoise(double intensityToNoise);

    void setName(String name);

}
