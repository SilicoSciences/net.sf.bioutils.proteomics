/**
 * 
 */
package net.sf.bioutils.proteomics;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-04-08
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
	 * Test method for {@link net.sf.bioutils.proteomics.PeakUtils#findClosestToMZ(java.lang.Iterable, double)}.
	 */
	@Test
	public final void testFindClosestToMZ() {
		List<Peak> in = new ArrayList<Peak>();
		assertNull(PeakUtils.findClosestToMZ(in, 1));
	}
	
	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakUtils#findClosestToIntensity(java.lang.Iterable, int)}.
	 */
	@Test
	public final void testFindClosestToIntensity() {
		List<Peak> in = new ArrayList<Peak>();
		assertNull(PeakUtils.findClosestToIntensity(in, 1));
	}
	
	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakUtils#findClosestToMZ(java.lang.Iterable, double)}.
	 */
	@Test
	public final void testFindClosestToMZ01() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10,10));
		assertEquals(new PeakImpl(10,10), PeakUtils.findClosestToMZ(in, 1));
	}
	
	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakUtils#findClosestToIntensity(java.lang.Iterable, int)}.
	 */
	@Test
	public final void testFindClosestToIntensity01() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10,10));
		assertEquals(new PeakImpl(10,10), PeakUtils.findClosestToIntensity(in, 1));
	}
	
	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakUtils#findClosestToMZ(java.lang.Iterable, double)}.
	 */
	@Test
	public final void testFindClosestToMZ02() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10,10), new PeakImpl(9,9));
		assertEquals(new PeakImpl(9,9), PeakUtils.findClosestToMZ(in, 1));
	}
	
	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakUtils#findClosestToIntensity(java.lang.Iterable, int)}.
	 */
	@Test
	public final void testFindClosestToIntensity02() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10,10), new PeakImpl(9,9));
		assertEquals(new PeakImpl(9,9), PeakUtils.findClosestToIntensity(in, 1));
	}

	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakUtils#findHighestMZ(java.lang.Iterable)}.
	 */
	@Test
	public final void testFindHighestMZ() {
		List<Peak> in = new ArrayList<Peak>();
		assertNull(PeakUtils.findHighestMZ(in));
	}

	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakUtils#findHighestIntensity(java.lang.Iterable)}.
	 */
	@Test
	public final void testFindHighestIntensity() {
		List<Peak> in = new ArrayList<Peak>();
		assertNull(PeakUtils.findHighestMZ(in));
	}
	
	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakUtils#findHighestMZ(java.lang.Iterable)}.
	 */
	@Test
	public final void testFindHighestMZ01() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10,10));
		assertEquals(new PeakImpl(10,10), PeakUtils.findHighestMZ(in));
	}

	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakUtils#findHighestIntensity(java.lang.Iterable)}.
	 */
	@Test
	public final void testFindHighestIntensity01() {
		List<PeakImpl> in = Arrays.asList(new PeakImpl(10,10));
		assertEquals(new PeakImpl(10,10), PeakUtils.findHighestMZ(in));
	}

}
