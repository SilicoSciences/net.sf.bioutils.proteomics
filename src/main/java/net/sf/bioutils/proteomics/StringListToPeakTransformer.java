package net.sf.bioutils.proteomics;

import java.util.List;

import net.sf.kerner.utils.transformer.Transformer;

public interface StringListToPeakTransformer<P extends Peak> extends Transformer<List<? extends String>, P> {

	public P transform(List<? extends String> element) throws NumberFormatException;

}
