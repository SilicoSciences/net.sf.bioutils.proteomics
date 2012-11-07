package net.sf.bioutils.proteomics;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.kerner.utils.impl.KeyValue;

/**
 * A {@link Map} of additional meta-informations which are assigned to an {@link AnnotatableElement}.
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
 */
public interface Annotation<T> {

    void addAll(Annotation<T> annotation);

    void add(KeyValue<T, Object> anotation);

    void add(T key, Object value);

    void addCustomAnnotation(KeyValue<Object, Object> anotation);

    void addCustomAnnotation(Object key, Object value);

    boolean containsCustomKey(Object key);

    boolean containsKey(T key);

    boolean containsValue(Object value);

    List<Entry<T, Object>> entryList();

    Object get(T key);

    Object getCustom(Object key);

    List<Object> getCustomKeys();

    List<T> getKeys();

    int getSize();

    List<Object> getValues();

    boolean isEmpty();

}
