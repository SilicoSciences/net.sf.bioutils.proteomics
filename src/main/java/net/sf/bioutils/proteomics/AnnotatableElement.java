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
 * <p>
 * last reviewed: 2013-08-07
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2013-08-07
 * 
 */
public interface AnnotatableElement {

    /**
     * 
     * @return annotations which are assigned to this {@code AnnotatableElement}
     */
    AnnotationObject getAnnotation();

    void setAnnotation(AnnotationObject annotation);

}
