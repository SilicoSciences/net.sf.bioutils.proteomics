package net.sf.bioutils.proteomics;

import java.util.Collection;

import net.sf.kerner.utils.collections.map.collection.MapCollection;

/**
 * A {@link MapCollection} of additional meta-informations which are assigned to
 * an {@link AnnotatableElement}.
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
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2012-03-18
 * @see AnnotatableElement
 * @see Annotator
 * @see MapCollection
 */
public interface Annotation<K, V, L extends Collection<V>> extends MapCollection<K, V, L> {

}
