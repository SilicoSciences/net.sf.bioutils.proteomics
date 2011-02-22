package net.sf.bioutils.proteomics;
import java.util.List;

import net.sf.jtables.table.impl.StringTable;
import net.sf.kerner.utils.transformer.Transformer;


public interface ToPeakTransformer extends Transformer<StringTable, List<? extends Peak>> {

}
