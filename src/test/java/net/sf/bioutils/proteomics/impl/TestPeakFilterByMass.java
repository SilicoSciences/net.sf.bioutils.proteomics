package net.sf.bioutils.proteomics.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.sf.bioutils.proteomics.Peak;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * Test PeakFilterByMass(double).
 * 
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-08-01
 *
 */
public class TestPeakFilterByMass {

	private PeakFilterByMass<Peak> f;
	
	private Peak p1;
	
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

	@Test
	public final void testVisit01() {
		p1 = new PeakImpl(1,1);
		f = new PeakFilterByMass<Peak>(1);
		assertTrue(f.visit(p1));
	}
	
	@Test
	public final void testVisit02() {
		p1 = new PeakImpl(1,1);
		f = new PeakFilterByMass<Peak>(1.001);
		assertFalse(f.visit(p1));
	}
	
	@Test
	public final void testVisit03() {
		p1 = new PeakImpl(1,1);
		f = new PeakFilterByMass<Peak>(0.999);
		assertFalse(f.visit(p1));
	}
	
	@Test
	public final void testVisit04() {
		p1 = new PeakImpl(1,5);
		f = new PeakFilterByMass<Peak>(1);
		assertTrue(f.visit(p1));
	}
	
	@Test
	public final void testVisit05() {
		p1 = new PeakImpl(1,5);
		f = new PeakFilterByMass<Peak>(1.001);
		assertFalse(f.visit(p1));
	}
	
	@Test
	public final void testVisit06() {
		p1 = new PeakImpl(1,5);
		f = new PeakFilterByMass<Peak>(0.999);
		assertFalse(f.visit(p1));
	}

}
