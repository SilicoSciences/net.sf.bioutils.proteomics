package net.sf.bioutils.proteomics.feature;

import java.util.List;

import net.sf.bioutils.proteomics.peak.Peak;

/**
 * TODO description
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
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2011-11-12
 */
public interface FactoryFeature {

    Feature create(List<? extends Peak> members);

}
