package net.sf.bioutils.proteomics.fraction;

import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.standard.Standard;
import net.sf.kerner.utils.Factory;

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
 * last reviewed: 2013-09-27
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * 
 */
public interface FactoryFraction extends Factory<Fraction> {

    Fraction create(String name);

    Fraction create(String name, List<Peak> peaks, ArrayList<Standard> standards);

    String getName();

    void setName(String name);

}
