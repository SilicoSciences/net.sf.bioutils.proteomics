package net.sf.bioutils.proteomics.annotation;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.peak.PeakFractionated;

/**
 *
 * A {@link Peak} which is also an {@link AnnotatableElement} and a
 * {@link PeakFractionated}.
 *
 * <p>
 * <b>Example:</b><br>
 * </p>
 *
 * <p>
 *
 * <pre>
 * TODO example
 * </pre>
 *
 * </p>
 *
 *
 *
 * <p>
 * last reviewed: 2014-05-16
 * </p>
 *
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 *
 */
public interface PeakAnnotatable extends PeakFractionated, AnnotatableElement {

    @Override
    PeakAnnotatable clone();

}
