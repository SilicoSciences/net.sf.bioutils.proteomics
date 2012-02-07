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
		return String.format("%12.6f", peak.getMZ());
	}

	public static String intensityToString(Peak peak) {
		return String.format("%6.0f", peak.getIntensity());
	}

	public static String intensityToNoiseToString(Peak peak) {
		return String.format("%6.0f", peak.getIntensityToNoise());
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
		Collections.sort(copy, new ComparatorPeakByMZ());
		return copy.get(copy.size() - 1);
	}

	public static <T extends Peak> T findHighestIntensity(Iterable<T> peaks) {
		final List<T> copy = new ArrayList<T>();
		for (T p : peaks) {
			copy.add(p);
		}
		if (copy.isEmpty())
			return null;
		Collections.sort(copy, new ComparatorPeakByIntensity());
		return copy.get(copy.size() - 1);
	}

}
