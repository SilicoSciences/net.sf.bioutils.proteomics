package net.sf.bioutils.proteomics;

import net.sf.kerner.utils.Transformer;
import net.sf.kerner.utils.collections.list.TransformerList;

public interface PeakView<V> extends Transformer<Peak, V>, TransformerList<Peak, V> {

}
