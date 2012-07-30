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

import net.sf.kerner.utils.Factory;
import net.sf.kerner.utils.collections.list.FactoryList;

/**
 * A {@link Factory} to create instances of {@link Standard}.
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
 * @see Factory
 * @see Standard
 * @see FactoryList
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version Jul 30, 2012
 */
public interface FactoryStandard extends FactoryList<Standard> {

    /**
     * TODO description
     * 
     * @param mz
     *            new standard's mass to charge ratio
     * @param intensity
     *            new standard's intensity
     * @return a new {@link Standard}
     */
    Standard create(double mz, double intensity);

}
