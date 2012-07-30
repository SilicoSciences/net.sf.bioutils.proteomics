package net.sf.bioutils.proteomics;

import java.util.List;

/**
 * A {@code Fraction} is a collection of {@link Peak Peaks} eluting at the same time.
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
 * @version 2012-07-30
 */
public interface Fraction {

    /**
     * Retrieve name of this fraction.
     * 
     * @return name of this fraction
     */
    String getName();

    /**
     * Retrieve this fraction's {@link Peak Peaks}
     * 
     * @return this fraction's {@link Peak Peaks}
     */
    List<Peak> getPeaks();

    /**
     * Retrieve number of {@link Peak Peaks} in this fraction. </p> <b>Note:</> {@code null} peaks are not counted!
     * 
     * @return number of {@link Peak Peaks} in this fraction
     */
    int getSize();

    /**
     * Retrieve this fraction's {@link Standard Standards}.
     * 
     * @return this fraction's {@link Standard Standards}
     */
    List<Standard> getStandards();

    /**
     * Check, weather this fraction is empty {@code getSize() == 0}.
     * 
     * @return {@code true}, if number of {@link Peak Peaks} in this fraction is {@code 0}; {@code false} otherwise
     */
    boolean isEmpty();

}
