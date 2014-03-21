/**********************************************************************
 Copyright (c) 2012-2014 Alexander Kerner. All rights reserved.
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

package net.sf.bioutils.proteomics.sample;

import java.util.List;
import java.util.Properties;

import net.sf.bioutils.proteomics.User;
import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.Cloneable;

public interface Sample extends Iterable<Fraction>, Cloneable<Sample> {

    /**
     * Returns a new instance of this {@code Sample}, which is identical (name,
     * user, fractions, properties) to this one.
     */
    @Override
    Sample clone();

    /**
     * 
     * Clones sample, using new given name.
     * 
     * @see #clone()
     */
    Sample clone(String newName);

    /**
     * 
     * Clones sample, dismissing fractions.
     * 
     * @see #clone()
     */
    Sample cloneWOFractions();

    List<Fraction> getFractions();

    String getName();

    Properties getProperties();

    /**
     * 
     * @return the number of {@link Peak peaks} in this {@code Sample}.
     */
    int getSize();

    User getUser();

    void setFractions(List<? extends Fraction> fraction);

    void setProperties(Properties properties);

}
