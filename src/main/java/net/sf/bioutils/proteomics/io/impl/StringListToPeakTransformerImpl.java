package net.sf.bioutils.proteomics.io.impl;

import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.PeakFactory;
import net.sf.bioutils.proteomics.io.AbstractStringListToPeakTransformer;

public class StringListToPeakTransformerImpl<P extends Peak> extends AbstractStringListToPeakTransformer<P>{
	
	private final PeakFactory<P> factory;

	public StringListToPeakTransformerImpl(int massIndex, int intensityIndex, PeakFactory<P> factory) {
		super(massIndex, intensityIndex);
		this.factory = factory;
	}

	@Override
	public P transform(List<? extends String> element)
			throws NumberFormatException {
		if(element.size() < massIndex || element.size() < intensityIndex)
			throw new NumberFormatException("string list does not have secified index " + element);
		return factory.create(Double.parseDouble(element.get(massIndex).trim()),
				Double.parseDouble(element.get(intensityIndex).trim()));
	}

}
