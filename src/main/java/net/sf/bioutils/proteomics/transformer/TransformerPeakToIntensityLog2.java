package net.sf.bioutils.proteomics.transformer;

import net.sf.bioutils.proteomics.provider.ProviderIntensity;
import net.sf.kerner.utils.math.UtilMath;

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
 * <b>Threading:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * Fully thread save (stateless).
 * </pre>
 * 
 * </p>
 * <p>
 * last reviewed: 2014-02-18
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * 
 */
public class TransformerPeakToIntensityLog2 extends TransformerPeakToIntensity {

    @Override
    public Double transform(final ProviderIntensity element) {
        return UtilMath.log2(super.transform(element));
    }
}
