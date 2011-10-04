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

/**
 * 
 * TODO description
 * 
 * <p>
 * <b>Example:</b><br>
 *
 * </p>
 * <p>
 * <pre>
 * TODO example
 * </pre>
 * </p>
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-10-04
 *
 * @param <P> type of {@link Peak}
 */
public class PeakReader<P extends Peak> implements IOIterator<P> {
	
	public final static String DEFAULT_DELIM = "\t";
	
	public final static boolean DEFAULT_HAS_HEADER = false;

	protected final StringTableReader reader;

	protected final StringListToPeakTransformer<P> transformer;

	public PeakReader(InputStream stream, String delim, boolean header,
			StringListToPeakTransformer<P> transformer) throws IOException {
		this(IOUtils.inputStreamToReader(stream), delim, header, transformer);
	}

	public PeakReader(InputStream stream, StringListToPeakTransformer<P> transformer)
			throws IOException {
		this(stream, DEFAULT_DELIM, DEFAULT_HAS_HEADER, transformer);
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
