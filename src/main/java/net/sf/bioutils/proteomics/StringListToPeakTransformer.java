package net.sf.bioutils.proteomics;

import java.util.List;

import net.sf.kerner.utils.transformer.Transformer;

public class StringListToPeakTransformer implements
		Transformer<List<? extends String>, Peak> {

	private final int massIndex;

	private final int intensityIndex;

	private final PeakFactory peakFactory;

	public StringListToPeakTransformer(int massIndex, int intensityIndex,
			PeakFactory peakFactory) {
		this.massIndex = massIndex;
		this.intensityIndex = intensityIndex;
		if (peakFactory == null)
			this.peakFactory = new PeakFactoryDefault();
		else
			this.peakFactory = peakFactory;
	}

	public Peak transform(List<? extends String> element) throws NumberFormatException {
		return peakFactory.create(Double.parseDouble(element.get(massIndex)),
				Integer.parseInt(element.get(intensityIndex)));
	}

}
