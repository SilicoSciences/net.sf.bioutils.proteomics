package net.sf.bioutils.proteomics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMassUnitPpm {
	
	private MassUnit m;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		m = MassUnit.DALTON;
	}

	@After
	public void tearDown() throws Exception {
		m = null;
	}

	@Test
	public final void testToPpm01() {
		assertEquals(30, m.toPpm(1000, 0.03), 0);
	}

	@Test
	public final void testToAbs01() {
		assertEquals(0.03, m.toAbs(1000, 30), 0);
	}
	
	@Test
	public final void testToPpm02() {
		assertEquals(30, m.toPpm(3000, 0.09), 0);
	}

	@Test
	public final void testToAbs02() {
		assertEquals(0.09, m.toAbs(3000, 30), 0);
	}

}
