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
package net.sf.bioutils.proteomics.sample.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.sample.Sample;

public class UtilSample {

    // private final static Logger log =
    // LoggerFactory.getLogger(UtilSample.class);

    public static List<Sample> clone(final List<Sample> samples) {
        final List<Sample> result = new ArrayList<Sample>(samples.size());
        for (final Sample s : samples) {
            result.add(s.clone());
        }
        return result;
    }

}
