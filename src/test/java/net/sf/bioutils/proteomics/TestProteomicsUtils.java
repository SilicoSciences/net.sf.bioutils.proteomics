package net.sf.bioutils.proteomics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProteomicsUtils {

	@Test
	public final void testToPpm01() {
		assertEquals(30, ProteomicsUtils.getPpmDelta(1000, 0.03), 0);
	}

	@Test
	public final void testToAbs01() {
		assertEquals(0.03, ProteomicsUtils.getAbsDelta(1000, 30), 0);
	}
	
	@Test
	public final void testToPpm02() {
		assertEquals(30, ProteomicsUtils.getPpmDelta(3000, 0.09), 0);
	}

	@Test
	public final void testToAbs02() {
		assertEquals(0.09, ProteomicsUtils.getAbsDelta(3000, 30), 0);
	}

}
