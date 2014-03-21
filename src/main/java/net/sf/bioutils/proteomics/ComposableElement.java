package net.sf.bioutils.proteomics;

import java.util.List;

/**
 * TODO description
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
 * last reviewed 2011-11-10
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2012-11-10
 * @param <T>
 */
public interface ComposableElement<T> {

    /**
     * Retrieve all member elements which compose this element.
     * 
     * @return all members of this {@code ComposableElement}
     */
    List<T> getMembers();

}
