package net.sf.bioutils.proteomics.impl;

import static org.junit.Assert.*;

import net.sf.bioutils.proteomics.Peak;
import net.sf.jranges.range.doublerange.impl.DummyDoubleRange;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * Test PeakFilterByMass(DoubleRange).
 * 
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-08-01
 *
 */
public class TestPeakFilterByMass2 {

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
		f = new PeakFilterByMass<Peak>(new DummyDoubleRange(0.999, 1.001));
		assertTrue(f.visit(p1));
	}
	
	@Test
	public final void testVisit02() {
		p1 = new PeakImpl(1.0011,1);
		f = new PeakFilterByMass<Peak>(new DummyDoubleRange(0.999, 1.001));
		assertFalse(f.visit(p1));
	}

}