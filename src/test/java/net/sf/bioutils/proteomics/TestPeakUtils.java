/**
 * 
 */
package net.sf.bioutils.proteomics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.bioutils.proteomics.impl.PeakImpl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-05-31
 * 
 */
public class TestPeakUtils {

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
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToMZ(java.lang.Iterable, double)}
	 * .
	 */
	@Test
	public final void testFindClosestToMZ() {
		List<Peak> in = new ArrayList<Peak>();
		assertNull(UtilPeak.findClosestToMZ(in, 1));
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToIntensity(java.lang.Iterable, double)}
	 * .
	 */
	@Test
	public final void testFindClosestToIntensity() {
		List<Peak> in = new ArrayList<Peak>();
		assertNull(UtilPeak.findClosestToIntensity(in, 1));
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToMZ(java.lang.Iterable, double)}
	 * .
	 */
	@Test
	public final void testFindClosestToMZ01() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10));
		assertEquals(new PeakImpl(10, 10), UtilPeak.findClosestToMZ(in, 1));
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToIntensity(java.lang.Iterable, double)}
	 * .
	 */
	@Test
	public final void testFindClosestToIntensity01() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10));
		assertEquals(new PeakImpl(10, 10), UtilPeak.findClosestToIntensity(in, 1));
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToMZ(java.lang.Iterable, double)}
	 * .
	 */
	@Test
	public final void testFindClosestToMZ02() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10), new PeakImpl(9, 9));
		assertEquals(new PeakImpl(9, 9), UtilPeak.findClosestToMZ(in, 1));
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToIntensity(java.lang.Iterable, double)}
	 * .
	 */
	@Test
	public final void testFindClosestToIntensity02() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10), new PeakImpl(9, 9));
		assertEquals(new PeakImpl(9, 9), UtilPeak.findClosestToIntensity(in, 1));
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.UtilPeak#findHighestMZ(java.lang.Iterable)}
	 * .
	 */
	@Test
	public final void testFindHighestMZ() {
		List<Peak> in = new ArrayList<Peak>();
		assertNull(UtilPeak.findHighestMZ(in));
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.UtilPeak#findHighestIntensity(java.lang.Iterable)}
	 * .
	 */
	@Test
	public final void testFindHighestIntensity() {
		List<Peak> in = new ArrayList<Peak>();
		assertNull(UtilPeak.findHighestMZ(in));
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.UtilPeak#findHighestMZ(java.lang.Iterable)}
	 * .
	 */
	@Test
	public final void testFindHighestMZ01() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10));
		assertEquals(new PeakImpl(10, 10), UtilPeak.findHighestMZ(in));
	}

	/**
	 * Test method for
	 * {@link net.sf.bioutils.proteomics.UtilPeak#findHighestIntensity(java.lang.Iterable)}
	 * .
	 */
	@Test
	public final void testFindHighestIntensity01() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10));
		assertEquals(new PeakImpl(10, 10), UtilPeak.findHighestMZ(in));
	}

}
