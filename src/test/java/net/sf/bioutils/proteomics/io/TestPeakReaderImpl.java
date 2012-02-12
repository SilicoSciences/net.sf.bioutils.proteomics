/**
 * 
 */
package net.sf.bioutils.proteomics.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.StringListToPeakTransformer;
import net.sf.bioutils.proteomics.impl.PeakImpl;
import net.sf.bioutils.proteomics.impl.PeakImplFactory;
import net.sf.bioutils.proteomics.io.PeakReader;
import net.sf.bioutils.proteomics.io.StringListToPeakTransformerImpl;
import net.sf.kerner.utils.io.IOUtils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TODO description
 * 
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
 * @version 2011-04-12
 * 
 */
public class TestPeakReaderImpl {

	private StringListToPeakTransformer<Peak> transformer = new StringListToPeakTransformerImpl<Peak>(
			0, 1, new PeakImplFactory());

	private PeakReader<Peak> r;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.io.PeakReader#readAll()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testReadAll() throws IOException {
		StringReader sreader = new StringReader("1 1" + IOUtils.NEW_LINE_STRING + "2 2");
		r = new PeakReader<Peak>(sreader, " ", false, transformer);
		assertArrayEquals(new PeakImpl[] { new PeakImpl(1, 1), new PeakImpl(2, 2) }, r.readAll()
				.toArray());
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.io.PeakReader#next()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testNext() throws IOException {
		StringReader sreader = new StringReader("1\t1" + IOUtils.NEW_LINE_STRING + "2\t2");
		r = new PeakReader<Peak>(sreader, "\t", false, transformer);
		assertTrue(r.hasNext());
		assertEquals(new PeakImpl(1, 1), r.next());
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.io.PeakReader#next()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testNext01() throws IOException {
		StringReader sreader = new StringReader("1g1" + IOUtils.NEW_LINE_STRING + "2g2");
		r = new PeakReader<Peak>(sreader, "g", false, transformer);
		assertTrue(r.hasNext());
		r.next();
		assertTrue(r.hasNext());
		assertEquals(new PeakImpl(2, 2), r.next());
	}

}
