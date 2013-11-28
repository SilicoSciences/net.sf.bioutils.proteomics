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

package net.sf.bioutils.proteomics.peak.impl;

import java.util.ArrayList;
import java.util.Collection;

import net.sf.bioutils.proteomics.peak.Peak;

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
 * last reviewed: 0000-00-00
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * 
 */
public class Peaks extends ArrayList<Peak> {

    private static final long serialVersionUID = 4837095714315079608L;

    private int cacheHash;

    public Peaks() {
        super();
    }

    public Peaks(final Collection<? extends Peak> c) {
        super(c);
    }

    public Peaks(final int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public synchronized int hashCode() {
        int result = cacheHash;
        if (result == 0) {
            result = super.hashCode();
            cacheHash = result;
        }
        return result;
    }

}
