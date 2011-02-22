package net.sf.bioutils.proteomics;

import java.util.ArrayList;
import java.util.List;

import net.sf.jtables.table.impl.StringTable;

public class ToPeakTransformerImpl implements ToPeakTransformer {
	
	private final String massRowIdent;
	
	private final String intensityRowIdent;
	
	public ToPeakTransformerImpl(String massRowIdent, String intensityRowIdent){
		this.massRowIdent = massRowIdent;
		this.intensityRowIdent = intensityRowIdent;
	}

	public List<? extends Peak> transform(StringTable t) {
		final List<Peak> result = new ArrayList<Peak>();
		
		final List<String> rowMass = t.getColumn(massRowIdent);
		final List<String> rowHeight = t.getColumn(intensityRowIdent);
		
		for(int k = 0; k < rowMass.size(); k++){
			result.add(new PeakImpl(null, Double.parseDouble(rowMass.get(k).trim()), Integer.parseInt(rowHeight.get(k).trim())));
		}
		return result;
	}

}
