package net.sf.bioutils.proteomics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.bioutils.proteomics.impl.ComparatorPeakByIntensity;
import net.sf.bioutils.proteomics.impl.ComparatorPeakByMZ;

public class PeakUtils {

	private PeakUtils() {
	}

	public static String mzToString(Peak peak) {
		return mzToString(peak.getMZ());
	}
	
	public static String mzToString(double mz) {
		return String.format("%4.4f", mz);
	}

	public static String intensityToString(Peak peak) {
		return intensityToString(peak.getIntensity());
	}
	
	public static String intensityToString(double intensity) {
		return String.format("%3.0f", intensity);
	}

	public static String intensityToNoiseToString(Peak peak) {
		return String.format("%3.0f", peak.getIntensityToNoise());
	}
	
	public static String ppmToString(double ppm) {
		return String.format("%6.2f", ppm);
	}

	public static <T extends Peak> T findClosestToMZ(Iterable<T> peaks, double mass) {
		T result = null;
		for (T p : peaks) {
			if (result == null)
				result = p;
			else {
				final double massDiffNew = Math.abs(mass - p.getMZ());

				// TODO cache this
				final double massDiffOld = Math.abs(mass - result.getMZ());

				if (massDiffNew < massDiffOld) {
					result = p;
				}
			}
		}
		return result;
	}

	public static <T extends Peak> T findClosestToIntensity(Iterable<T> peaks, int intensity) {
		T result = null;
		for (T p : peaks) {
			if (result == null)
				result = p;
			else {
				final double intDiffNew = Math.abs(intensity - p.getIntensity());

				// TODO cache this
				final double intDiffOld = Math.abs(intensity - result.getIntensity());

				if (intDiffNew < intDiffOld) {
					result = p;
				}
			}
		}
		return result;
	}

	public static <T extends Peak> T findHighestMZ(Iterable<T> peaks) {
		final List<T> copy = new ArrayList<T>();
		for (T p : peaks) {
			copy.add(p);
		}
		if (copy.isEmpty())
			return null;
		Collections.sort(copy, new ComparatorPeakByMZ<T>());
		return copy.get(copy.size() - 1);
	}

	public static <T extends Peak> T findHighestIntensity(Iterable<T> peaks) {
		final List<T> copy = new ArrayList<T>();
		for (T p : peaks) {
			copy.add(p);
		}
		if (copy.isEmpty())
			return null;
		Collections.sort(copy, new ComparatorPeakByIntensity<T>());
		return copy.get(copy.size() - 1);
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
	
	public static double getPpmDeltaMz(Peak p1, Peak p2) {
		final double absDiff = Math.abs(p1.getMZ() - p2.getMZ());
		return getPpmDelta(p1.getMZ(), absDiff);
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
