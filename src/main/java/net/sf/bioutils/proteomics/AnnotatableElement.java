package net.sf.bioutils.proteomics;

/**
 * 
 * An object to which meta-information can be attached. </p> This information is
 * stored in an {@link Annotation} object. </p> The progress of assigning
 * annotations is performed by an {@link Annotator}.
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
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2012-03-17
 * 
 * @see Annotator
 * 
 */
public interface AnnotatableElement<T> {

    /**
     * 
     * TODO description
     * 
     * @return {@link Annotation} which are assigned to this
     *         {@code AnnotatableElement}
     */
    Annotation<T> getAnnotation();

    void setAnnotation(Annotation<T> annotation);

}
