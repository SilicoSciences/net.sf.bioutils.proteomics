package net.sf.bioutils.proteomics.impl;

import static org.junit.Assert.*;

import java.util.List;

import net.sf.jranges.range.doublerange.impl.DummyDoubleRange;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPeakFilterByMZ {
	
	private PeakFilterByMZ<PeakImpl> filter;
	
	private PeakImpl p1;
	

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
		filter = new PeakFilterByMZ(0.001);
		p1 = new PeakImpl(0.001, 1);
		assertTrue(filter.visit(p1));
	}
	
	@Test
	public final void testVisit02() {
		filter = new PeakFilterByMZ(0.001);
		p1 = new PeakImpl(0.002, 1);
		assertFalse(filter.visit(p1));
	}
	
	@Test
	public final void testVisit03() {
		filter = new PeakFilterByMZ(0.001);
		assertFalse(filter.visit(null));
	}
	
	@Test
	public final void testVisit04() {
		filter = new PeakFilterByMZ(new DummyDoubleRange(0.001, 0.002));
		p1 = new PeakImpl(0.001, 1);
		assertTrue(filter.visit(p1));
	}
	
	@Test
	public final void testVisit05() {
		filter = new PeakFilterByMZ(new DummyDoubleRange(0.001, 0.002));
		p1 = new PeakImpl(0.002, 1);
		assertTrue(filter.visit(p1));
	}
	
	@Test
	public final void testVisit06() {
		filter = new PeakFilterByMZ(new DummyDoubleRange(0.001, 0.002));
		p1 = new PeakImpl(0.0015, 1);
		assertTrue(filter.visit(p1));
	}
	
	@Test
	public final void testVisit07() {
		filter = new PeakFilterByMZ(new DummyDoubleRange(0.001, 0.002));
		p1 = new PeakImpl(0.0009, 1);
		assertFalse(filter.visit(p1));
	}
	
	@Test
	public final void testVisit08() {
		filter = new PeakFilterByMZ(new DummyDoubleRange(0.001, 0.002));
		p1 = new PeakImpl(0.0021, 1);
		assertFalse(filter.visit(p1));
	}

}
