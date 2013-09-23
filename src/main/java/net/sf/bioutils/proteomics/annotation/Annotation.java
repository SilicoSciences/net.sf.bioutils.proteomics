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

package net.sf.bioutils.proteomics.annotation;

import java.util.Collection;

import net.sf.kerner.utils.collections.map.collection.MapCollection;

/**
 * A {@link MapCollection} of additional meta-informations which are assigned to
 * an {@link AnnotatableElement}.
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
 * last reviewed: 2013-08-07
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2013-08-07
 * 
 * @param <K>
 * @param <V>
 * @param <L>
 */
public interface Annotation<K, V, L extends Collection<V>> extends MapCollection<K, V, L> {

}
