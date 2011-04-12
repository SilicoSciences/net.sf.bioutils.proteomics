package net.sf.bioutils.proteomics;

import java.util.List;

import net.sf.kerner.utils.transformer.Transformer;

public class DoubleListToPeakTransformer implements
		Transformer<List<? extends Double>, Peak> {

	private final int massIndex;

	private final int intensityIndex;

	private final PeakFactory peakFactory;

	public DoubleListToPeakTransformer(int massIndex, int intensityIndex,
			PeakFactory peakFactory) {
		this.massIndex = massIndex;
		this.intensityIndex = intensityIndex;
		if (peakFactory == null)
			this.peakFactory = new PeakFactoryDefault();
		else
			this.peakFactory = peakFactory;
	}

	public Peak transform(List<? extends Double> element) {
		return peakFactory.create(element.get(massIndex),
				(int) element.get(intensityIndex).doubleValue());
	}

}
