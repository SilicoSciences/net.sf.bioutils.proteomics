package net.sf.bioutils.proteomics.io;

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
 * Read one or more {@link Peak}s from a
 * <ul>
 * <li>{@link File}</li>
 * <li>{@link InputStream} or</li>
 * <li>{@link Reader}.</li>
 * </ul>
 * </p> Data must be provided in a table that looks e.g. like this:
 * 
 * <pre>
 * Index	Centroid Mass	Lower Bound	Upper Bound	Charge (z)	Height	Relative Intensity	Area	S/N Ratio	Resolution	Isotope Cluster Area
 * 1	750.209595	749.96	750.32	1	35	0.09	265.57	14.18	7843.93	442.66
 * 2	750.399170	750.32	750.51	1	38	0.10	148.75	11.57	9230.13	227.01
 * 3	751.209717	750.96	751.32	1	35	0.09	303.06	10.91	5679.66	284.02
 * 4	752.209961	751.90	752.34	1	35	0.09	322.02	11.32	6801.44	334.59
 * 5	757.189270	756.99	757.31	1	34	0.09	279.61	10.81	6816.37	277.10
 * 6	757.405212	757.31	757.65	1	37	0.10	241.22	13.10	7475.50	291.90
 * 7	758.195313	758.02	758.33	1	36	0.10	275.98	11.62	7205.49	274.32
 * 8	759.192200	758.92	759.32	1	32	0.08	341.93	10.29	4591.59	386.40
 * </pre>
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-10-04
 * 
 * @param <P>
 *            type of {@link Peak}
 */
public class PeakReader<P extends Peak> implements IOIterator<P> {

	/**
	 * Default column delimiter.
	 */
	public final static String DEFAULT_DELIM = "\t";

	public final static boolean DEFAULT_HAS_HEADER = false;

	/**
	 * {@link StringTableReader} to which reading is delegated.
	 */
	protected final StringTableReader reader;

	/**
	 * {@link Transformer} that is used to build a {@link Peak} from one line of
	 * read table.
	 */
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

	/**
	 * 
	 * Read all peaks at once. If is was not possible to build {@link Peak} from
	 * provided line (e.g. empty line), line is ignored.
	 * 
	 * @return {@link List} of extracted {@link Peak}s
	 * @throws IOException
	 *             if reading failes
	 */
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

	/**
	 * Read next line/ peak.
	 */
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
