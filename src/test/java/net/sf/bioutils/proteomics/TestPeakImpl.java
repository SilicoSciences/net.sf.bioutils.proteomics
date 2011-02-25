/**
 * 
 */
package net.sf.bioutils.proteomics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-02-24
 *
 */
public class TestPeakImpl {
	
	private PeakImpl p1, p2;

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
		p1 = p2 = null; 
	}

	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakImpl#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		p1 = new PeakImpl(null, 0, 0);
		p2 = new PeakImpl(null, 0, 0);
		assertEquals(p1.hashCode(), p2.hashCode());
	}

	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakImpl#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		p1 = new PeakImpl(null, 0, 0);
		p2 = new PeakImpl(null, 0, 0);
		assertEquals(p1, p2);
	}
	
	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakImpl#hashCode()}.
	 */
	@Test
	public final void testHashCode01() {
		p1 = new PeakImpl(null, 1, 1);
		p2 = new PeakImpl(null, 1, 1);
		assertEquals(p1.hashCode(), p2.hashCode());
	}

	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakImpl#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject01() {
		p1 = new PeakImpl(null, 1, 1);
		p2 = new PeakImpl(null, 1, 1);
		assertEquals(p1, p2);
	}
	
	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakImpl#hashCode()}.
	 */
	@Test
	public final void testHashCode02() {
		p1 = new PeakImpl(null, 1, 1);
		p2 = new PeakImpl(null, 2, 2);
		assertNotSame(p1.hashCode(), p2.hashCode());
	}

	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakImpl#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject02() {
		p1 = new PeakImpl(null, 1, 1);
		p2 = new PeakImpl(null, 2, 2);
		assertNotSame(p1, p2);
	}
	
	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakImpl#hashCode()}.
	 */
	@Test
	public final void testHashCode03() {
		p1 = new PeakImpl("p1", 1, 1);
		p2 = new PeakImpl(null, 1, 1);
		assertNotSame(p1.hashCode(), p2.hashCode());
	}

	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakImpl#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject03() {
		p1 = new PeakImpl("p1", 1, 1);
		p2 = new PeakImpl(null, 1, 1);
		assertNotSame(p1, p2);
	}
	
	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakImpl#hashCode()}.
	 */
	@Test
	public final void testHashCode04() {
		p1 = new PeakImpl("null", 1, 1);
		p2 = new PeakImpl("null", 1, 1);
		assertEquals(p1.hashCode(), p2.hashCode());
	}

	/**
	 * Test method for {@link net.sf.bioutils.proteomics.PeakImpl#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject04() {
		p1 = new PeakImpl("null", 1, 1);
		p2 = new PeakImpl("null", 1, 1);
		assertEquals(p1, p2);
	}

}
