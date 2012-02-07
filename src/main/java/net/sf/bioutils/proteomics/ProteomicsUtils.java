package net.sf.bioutils.proteomics;

public class ProteomicsUtils {

	private ProteomicsUtils() {
	}

	/**
	 * 
	 * Converts an absolute delta to according PPM delta.
	 * 
	 * @param parent
	 * @param absDelta
	 * @return converted delta
	 */
	public static double getPpmDelta(double parent, double absDelta) {
		return 1.0E+6 * absDelta / parent;
	}

	/**
	 * 
	 * Converts an PPM delta to according absolute delta.
	 * 
	 * @param parent
	 * @param ppmDelta
	 * @return converted delta
	 */
	public static double getAbsDelta(double parent, double ppmDelta) {
		return ppmDelta * parent / 1.0E+6;
	}

}
