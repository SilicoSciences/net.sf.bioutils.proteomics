package net.sf.bioutils.proteomics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeakUtils {

	private PeakUtils() {
	}

	public static Peak findClosestToMZ(Iterable<? extends Peak> peaks, double mass) {
		Peak result = null;
		for (Peak p : peaks) {
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

	public static Peak findClosestToIntensity(Iterable<? extends Peak> peaks, int intensity) {
		Peak result = null;
		for (Peak p : peaks) {
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
	
	public static Peak findHighestMZ(Iterable<? extends Peak> peaks) {
		final List<Peak> copy = new ArrayList<Peak>();
		for(Peak p : peaks){
			copy.add(p);
		}
		Collections.sort(copy, new PeakComparatorByMZ(false));
		return copy.get(0);
	}
	
	public static Peak findHighestIntensity(Iterable<? extends Peak> peaks) {
		final List<Peak> copy = new ArrayList<Peak>();
		for(Peak p : peaks){
			copy.add(p);
		}
		Collections.sort(copy, new PeakComparatorByIntensity(false));
		return copy.get(0);
	}

}
