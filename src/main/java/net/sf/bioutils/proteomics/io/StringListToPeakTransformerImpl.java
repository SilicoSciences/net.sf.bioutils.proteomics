package net.sf.bioutils.proteomics.io;

import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.PeakFactory;

public class StringListToPeakTransformerImpl<P extends Peak> extends
		AbstractStringListToPeakTransformer<P> {

	private final PeakFactory<P> factory;

	public StringListToPeakTransformerImpl(int massIndex, int intensityIndex, PeakFactory<P> factory) {
		super(massIndex, intensityIndex);
		this.factory = factory;
	}

	@Override
	public P transform(List<? extends String> element) throws NumberFormatException {
		try {
			return factory.create(Double.parseDouble(element.get(massIndex).trim()),
					Double.parseDouble(element.get(intensityIndex).trim()));
		} catch (Exception e) {
			return null;
		}
	}
}
