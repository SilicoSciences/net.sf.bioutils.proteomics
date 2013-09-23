package net.sf.bioutils.proteomics.impl;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.list.impl.AbstractTransformingListFactory;

/**
 * 
 * TODO description
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
 * last reviewed: 2013-07-22
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2013-07-22
 * 
 */
public class TransformerPeakToFractionNr extends AbstractTransformingListFactory<Peak, Integer> {

    @Override
    public Integer transform(final Peak element) {
        return element.getFractionIndex();
    }

}
