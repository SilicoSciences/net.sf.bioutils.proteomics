package net.sf.bioutils.proteomics;

import java.util.List;

import net.sf.kerner.utils.Transformer;

public interface PeakToStringListTransformer<P extends Peak> extends Transformer<P, List<String>> {

}
