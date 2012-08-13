package net.sf.bioutils.proteomics;

import java.util.List;

/**
 * 
 * Extends {@code Fraction} by setter methods to provide modifiability.
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
 * @version 2012-06-04
 * 
 */
public interface FractionModifiable extends Fraction {

    void setName(String name);

    void setPeaks(List<? extends Peak> peaks);

    void setStandards(List<? extends Standard> standards);

}
