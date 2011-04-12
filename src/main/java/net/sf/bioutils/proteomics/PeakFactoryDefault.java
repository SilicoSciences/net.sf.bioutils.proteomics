package net.sf.bioutils.proteomics;

public class PeakFactoryDefault implements PeakFactory {

	public Peak create(double mz, int intensity) {
		return new PeakImpl(mz, intensity);
	}

}
