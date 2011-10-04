package net.sf.bioutils.proteomics.io.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.StringListToPeakTransformer;
import net.sf.jtables.table.impl.StringTableReader;
import net.sf.kerner.utils.io.IOUtils;
import net.sf.kerner.utils.io.buffered.IOIterator;

public class PeakReader<P extends Peak> implements IOIterator<P> {

	protected final StringTableReader reader;

	protected final StringListToPeakTransformer<P> transformer;

	public PeakReader(InputStream stream, String delim, boolean header,
			StringListToPeakTransformer<P> transformer) throws IOException {
		this(IOUtils.inputStreamToReader(stream), delim, header, transformer);
	}

	public PeakReader(InputStream stream, StringListToPeakTransformer<P> transformer)
			throws IOException {
		this(stream, "\t", false, transformer);
	}

	public PeakReader(Reader reader, String delim, boolean header,
			StringListToPeakTransformer<P> transformer) throws IOException {
		this.reader = new StringTableReader(reader, header, false, delim);
		this.transformer = transformer;
	}

	public List<P> readAll() throws IOException {
		final List<P> result = new ArrayList<P>();
		while (hasNext()) {
			try {
				result.add(next());
			} catch (NumberFormatException e) {
				// System.err.println();
			}
			;
		}
		return result;
	}

	public P next() throws IOException {
		return transformer.transform(reader.next());
	}

	public boolean hasNext() {
		return reader.hasNext();
	}

	public void close() {
		reader.close();
	}

}
