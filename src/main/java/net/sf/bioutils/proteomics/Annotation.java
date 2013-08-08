package net.sf.bioutils.proteomics;

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
