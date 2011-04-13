package net.sf.bioutils.proteomics.io;

import java.io.IOException;
import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.io.buffered.IOIterator;

public interface PeakReader<P extends Peak> extends IOIterator<P> {
	
	List<Peak> readAll() throws IOException;

}
