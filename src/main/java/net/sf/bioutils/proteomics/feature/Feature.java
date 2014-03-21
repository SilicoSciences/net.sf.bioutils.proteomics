package net.sf.bioutils.proteomics.feature;

import net.sf.bioutils.proteomics.ComposableElement;
import net.sf.bioutils.proteomics.peak.Peak;

/**
 * A {@code Feature} is a {@link ComposableElement} of {@link Peak Peaks}. It
 * represents one single peptide that was detected. One peptide is composed of
 * multiple signals (peaks). </p>
 * <p>
 * last reviewed 2011-11-10
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2012-11-09
 */
public interface Feature extends ComposableElement<Peak>, Peak, Iterable<Peak> {

    @Override
    Feature clone();

    /**
     * Implementation dependent. Typically, it will be the number of the
     * fraction which contains the {@link Peak} that contributes to this
     * {@code Feature} and has the highest intensity.
     * 
     * @return fraction number this {@code Feature} is associated with
     */
    int getCenterIndex();

    /**
     * First fraction this {@code Feature} occurs in. This is also the number of
     * the first fraction which contains a {@link Peak} contributing to this
     * {@code Feature}
     * 
     * @return index of first {@link Peak} contributing to this {@code Feature}
     */
    int getFirstIndex();

    /**
     * Last fraction this {@code Feature} occurs in. This is also the number of
     * the last fraction which contains a {@link Peak} contributing to this
     * {@code Feature}
     * 
     * @return index of last {@link Peak} contributing to this {@code Feature}
     */
    int getLastIndex();
}
