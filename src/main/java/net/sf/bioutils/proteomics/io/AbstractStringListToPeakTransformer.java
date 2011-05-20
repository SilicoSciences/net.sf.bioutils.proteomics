package net.sf.bioutils.proteomics.io;

import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.StringListToPeakTransformer;

public abstract class AbstractStringListToPeakTransformer<P extends Peak>
		implements StringListToPeakTransformer<P> {

	protected final int massIndex;

	protected final int intensityIndex;

	public AbstractStringListToPeakTransformer(int massIndex, int intensityIndex) {
		super();
		this.massIndex = massIndex;
		this.intensityIndex = intensityIndex;
	}

	public abstract P transform(List<? extends String> element)
			throws NumberFormatException;

}
