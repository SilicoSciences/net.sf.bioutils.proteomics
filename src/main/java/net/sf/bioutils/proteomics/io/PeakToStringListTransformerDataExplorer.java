package net.sf.bioutils.proteomics.io;

import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.PeakToStringListTransformer;

/**
 * <pre>
 * Index	Centroid Mass	Lower Bound	Upper Bound	Charge (z)	Height	Relative Intensity	Area	S/N Ratio	Resolution	Isotope Cluster Area
 * 1	750.359070	750.25	750.61	1	48	0.30	321.71	13.21	8077.45	536.24
 * 2	751.409485	750.96	751.73	1	418	2.58	2273.82	123.07	11420.31	3458.10
 * 3	753.425842	753.23	753.64	1	79	0.49	537.96	15.23	10068.62	402.92
 * 4	755.354370	754.99	755.67	1	42	0.26	351.54	11.08	9714.07	498.56
 * 5	757.415161	757.08	757.66	1	67	0.41	512.88	16.64	8261.98	604.96
 * 6	758.412354	758.26	758.75	1	70	0.43	491.72	15.03	9156.84	454.98
 * </pre>
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
 * @version Feb 22, 2012
 * 
 * @param <P>
 */
@Deprecated
public class PeakToStringListTransformerDataExplorer<P extends Peak> implements
		PeakToStringListTransformer<P> {

	public final static String DEFAULT_NO_DEF = "-1";

	@Override
	public List<String> transform(P p) {
		final List<String> result = new ArrayList<String>();
		result.add(DEFAULT_NO_DEF);
		result.add(Double.toString(p.getMZ()));
		result.add(DEFAULT_NO_DEF);
		result.add(DEFAULT_NO_DEF);
		result.add(DEFAULT_NO_DEF);
		result.add(Double.toString(p.getIntensity()));
		result.add(DEFAULT_NO_DEF);
		result.add(DEFAULT_NO_DEF);
		result.add(DEFAULT_NO_DEF);
		result.add(DEFAULT_NO_DEF);
		result.add(DEFAULT_NO_DEF);
		return result;
	}

}
