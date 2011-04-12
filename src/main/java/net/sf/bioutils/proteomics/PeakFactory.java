package net.sf.bioutils.proteomics;

public interface PeakFactory {
	
	Peak create(double mz, int intensity);

}
