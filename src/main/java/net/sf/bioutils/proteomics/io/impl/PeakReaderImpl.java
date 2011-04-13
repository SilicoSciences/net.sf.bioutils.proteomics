package net.sf.bioutils.proteomics.io.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.StringListToPeakTransformer;
import net.sf.bioutils.proteomics.io.PeakReader;
import net.sf.jtables.table.impl.StringTableReader;

public class PeakReaderImpl implements
		PeakReader<Peak> {
	
	private final StringTableReader reader;
	private final StringListToPeakTransformer t;
	
	public PeakReaderImpl(InputStream stream, String delim, int massIndex, int intensityIndex) throws IOException {
		this.reader = new StringTableReader(stream, false, false, delim);
		this.t = new StringListToPeakTransformer(massIndex, intensityIndex, null);
	}
	
	public PeakReaderImpl(InputStream stream) throws IOException {
		this(stream, null, 0, 1);
	}
	
	public PeakReaderImpl(Reader reader, String delim, int massIndex, int intensityIndex) throws IOException {
		this.reader = new StringTableReader(reader, false, false, delim);
		this.t = new StringListToPeakTransformer(massIndex, intensityIndex, null);
	}

	public List<Peak> readAll() throws IOException {
		final List<Peak> result = new ArrayList<Peak>();
		while (hasNext()) {
			result.add(next());
		}
		return result;
	}

	public Peak next() throws IOException {
		return t.transform(reader.next());
	}

	public boolean hasNext() {
		return reader.hasNext();
	}

	public void close() {
		reader.close();
	}
}
