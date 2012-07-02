package net.sf.bioutils.proteomics.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.sf.bioutils.proteomics.Peak;
import net.sf.jranges.range.doublerange.impl.DummyDoubleRange;
import net.sf.kerner.utils.collections.filter.Filter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPeakFilterByMZ {

    private Filter<Peak> filter;

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
        assertTrue(filter.filter(p1));
    }

    @Test
    public final void testVisit02() {
        filter = new PeakFilterByMZ(0.001);
        p1 = new PeakImpl(0.002, 1);
        assertFalse(filter.filter(p1));
    }

    @Test(expected = NullPointerException.class)
    public final void testVisit03() {
        filter = new PeakFilterByMZ(0.001);
        filter.filter(null);
    }

    @Test
    public final void testVisit04() {
        filter = new PeakFilterByMZRange(new DummyDoubleRange(0.001, 0.002));
        p1 = new PeakImpl(0.001, 1);
        assertTrue(filter.filter(p1));
    }

    @Test
    public final void testVisit05() {
        filter = new PeakFilterByMZRange(new DummyDoubleRange(0.001, 0.002));
        p1 = new PeakImpl(0.002, 1);
        assertTrue(filter.filter(p1));
    }

    @Test
    public final void testVisit06() {
        filter = new PeakFilterByMZRange(new DummyDoubleRange(0.001, 0.002));
        p1 = new PeakImpl(0.0015, 1);
        assertTrue(filter.filter(p1));
    }

    @Test
    public final void testVisit07() {
        filter = new PeakFilterByMZRange(new DummyDoubleRange(0.001, 0.002));
        p1 = new PeakImpl(0.0009, 1);
        assertFalse(filter.filter(p1));
    }

    @Test
    public final void testVisit08() {
        filter = new PeakFilterByMZRange(new DummyDoubleRange(0.001, 0.002));
        p1 = new PeakImpl(0.0021, 1);
        assertFalse(filter.filter(p1));
    }

}