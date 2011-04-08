package net.sf.bioutils.proteomics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeakUtils {

	private PeakUtils() {
	}

	public static <T extends Peak> T findClosestToMZ(Iterable<T> peaks, double mass) {
		T result = null;
		for (T p : peaks) {
			if (result == null)
				result = p;
			else {
				final double massDiffNew = Math.abs(mass
						- p.getMassOverCharge());

				// TODO cache this
				final double massDiffOld = Math.abs(mass
						- result.getMassOverCharge());

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
				final int intDiffNew = Math.abs(intensity
						- p.getIntensity());

				// TODO cache this
				final double intDiffOld = Math.abs(intensity
						- result.getIntensity());

				if (intDiffNew < intDiffOld) {
					result = p;
				}
			}
		}
		return result;
	}
	
	public static <T extends Peak> T findHighestMZ(Iterable<T> peaks) {
		final List<T> copy = new ArrayList<T>();
		for(T p : peaks){
			copy.add(p);
		}
		if(copy.isEmpty())
			return null;
		Collections.sort(copy, new PeakComparatorByMZ(false));
		return copy.get(0);
	}
	
	public static <T extends Peak> T findHighestIntensity(Iterable<T> peaks) {
		final List<T> copy = new ArrayList<T>();
		for(T p : peaks){
			copy.add(p);
		}
		if(copy.isEmpty())
			return null;
		Collections.sort(copy, new PeakComparatorByIntensity(false));
		return copy.get(0);
	}

}
