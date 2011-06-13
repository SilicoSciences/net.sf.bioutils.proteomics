package net.sf.bioutils.proteomics.impl;

import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.PeakFactory;
import net.sf.bioutils.proteomics.io.AbstractStringListToPeakTransformer;

public class StringListToPeakImplTransformer<P extends Peak> extends AbstractStringListToPeakTransformer<P>{
	
	private final PeakFactory<P> factory;

	public StringListToPeakImplTransformer(int massIndex, int intensityIndex, PeakFactory<P> factory) {
		super(massIndex, intensityIndex);
		this.factory = factory;
	}

	@Override
	public P transform(List<? extends String> element)
			throws NumberFormatException {
		return factory.create(Double.parseDouble(element.get(massIndex).trim()),
				Integer.parseInt(element.get(intensityIndex).trim()));
	}

}
