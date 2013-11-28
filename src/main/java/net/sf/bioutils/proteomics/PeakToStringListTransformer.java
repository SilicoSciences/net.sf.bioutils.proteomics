package net.sf.bioutils.proteomics;

import java.util.List;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.transformer.Transformer;

public interface PeakToStringListTransformer<P extends Peak> extends Transformer<P, List<String>> {

}
