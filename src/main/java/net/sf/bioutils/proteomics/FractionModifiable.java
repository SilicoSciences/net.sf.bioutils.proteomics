package net.sf.bioutils.proteomics;

import java.util.List;

/**
 * Extends {@code Fraction} by setter methods to provide modifiability.
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
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2012-11-12
 */
public interface FractionModifiable extends Fraction {

    void addPeak(Peak peak);

    void setName(String name);

    

}
