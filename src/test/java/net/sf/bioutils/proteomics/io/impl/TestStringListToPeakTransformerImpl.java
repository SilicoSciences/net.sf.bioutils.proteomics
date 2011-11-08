package net.sf.bioutils.proteomics.io.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import net.sf.bioutils.proteomics.PeakFactory;
import net.sf.bioutils.proteomics.impl.PeakImpl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStringListToPeakTransformerImpl {
	
	private StringListToPeakTransformerImpl<PeakImpl> t;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t = new StringListToPeakTransformerImpl<PeakImpl>(0, 1, new PeakFactory<PeakImpl>() {
			@Override
			public PeakImpl create() {
				return create(-1,-1);
			}
			@Override
			public PeakImpl create(double mz, double intensity) {
				return new PeakImpl(mz, intensity);
			}
		});
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public final void testTransform01() {
		assertEquals(new PeakImpl(1,2), t.transform(Arrays.asList("1","2")));
	}
	
	@Test
	public final void testTransform02() {
		assertNull(t.transform(Arrays.asList("1")));
	}
	
	@Test
	public final void testTransform03() {
		assertNull(t.transform(Arrays.asList("1")));
	}

}
