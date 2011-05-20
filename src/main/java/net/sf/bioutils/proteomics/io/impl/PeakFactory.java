package net.sf.bioutils.proteomics.io.impl;

import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.impl.PeakImpl;
import net.sf.bioutils.proteomics.io.AbstractStringListToPeakTransformer;

public class PeakFactory extends AbstractStringListToPeakTransformer<Peak>{

	public PeakFactory(int massIndex, int intensityIndex) {
		super(massIndex, intensityIndex);
	}

	@Override
	public Peak transform(List<? extends String> element)
			throws NumberFormatException {
		return new PeakImpl(Double.parseDouble(element.get(massIndex).trim()),
				Integer.parseInt(element.get(intensityIndex).trim()));
	}

}
