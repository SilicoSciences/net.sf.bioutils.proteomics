package net.sf.bioutils.proteomics.impl;

import java.util.Comparator;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.collections.impl.ComparatorNull;

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
 * last reviewed: 2013-08-08
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2013-08-08
 * 
 */
public class ComparatorPeakByMZ extends ComparatorNull<Peak> implements Comparator<Peak> {

    @Override
    public int compareNonNull(final Peak o1, final Peak o2) {

        return Double.compare(o1.getMz(), o2.getMz());

    }

}
