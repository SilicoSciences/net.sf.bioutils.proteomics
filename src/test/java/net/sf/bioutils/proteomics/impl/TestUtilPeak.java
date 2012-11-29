/**
 * 
 */
package net.sf.bioutils.proteomics.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.bioutils.proteomics.Peak;
import net.sf.bioutils.proteomics.UtilPeak;
import net.sf.bioutils.proteomics.impl.PeakImpl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUtilPeak {

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
     * Test method for {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToIntensity(java.lang.Iterable, double)} .
     */
    @Test
    public final void testFindClosestToIntensity() {
        final List<Peak> in = new ArrayList<Peak>();
        assertNull(UtilPeak.findClosestToIntensity(in, 1));
    }

    /**
     * Test method for {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToIntensity(java.lang.Iterable, double)} .
     */
    @Test
    public final void testFindClosestToIntensity01() {
        final List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10));
        assertEquals(new PeakImpl(10, 10), UtilPeak.findClosestToIntensity(in, 1));
    }

    /**
     * Test method for {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToIntensity(java.lang.Iterable, double)} .
     */
    @Test
    public final void testFindClosestToIntensity02() {
        final List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10), new PeakImpl(9, 9));
        assertEquals(new PeakImpl(9, 9), UtilPeak.findClosestToIntensity(in, 1));
    }

    /**
     * Test method for {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToMZ(java.lang.Iterable, double)} .
     */
    @Test
    public final void testFindClosestToMZ() {
        final List<Peak> in = new ArrayList<Peak>();
        assertNull(UtilPeak.findClosestToMZ(in, 1));
    }

    /**
     * Test method for {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToMZ(java.lang.Iterable, double)} .
     */
    @Test
    public final void testFindClosestToMZ01() {
        final List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10));
        assertEquals(new PeakImpl(10, 10), UtilPeak.findClosestToMZ(in, 1));
    }

    /**
     * Test method for {@link net.sf.bioutils.proteomics.UtilPeak#findClosestToMZ(java.lang.Iterable, double)} .
     */
    @Test
    public final void testFindClosestToMZ02() {
        final List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10), new PeakImpl(9, 9));
        assertEquals(new PeakImpl(9, 9), UtilPeak.findClosestToMZ(in, 1));
    }

    /**
     * Test method for {@link net.sf.bioutils.proteomics.UtilPeak#findHighestIntensity(java.lang.Iterable)} .
     */
    @Test
    public final void testFindHighestIntensity() {
        final List<Peak> in = new ArrayList<Peak>();
        assertNull(UtilPeak.findHighestMZ(in));
    }

    /**
     * Test method for {@link net.sf.bioutils.proteomics.UtilPeak#findHighestIntensity(java.lang.Iterable)} .
     */
    @Test
    public final void testFindHighestIntensity01() {
        final List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10));
        assertEquals(new PeakImpl(10, 10), UtilPeak.findHighestMZ(in));
    }

    /**
     * Test method for {@link net.sf.bioutils.proteomics.UtilPeak#findHighestMZ(java.lang.Iterable)} .
     */
    @Test
    public final void testFindHighestMZ() {
        final List<Peak> in = new ArrayList<Peak>();
        assertNull(UtilPeak.findHighestMZ(in));
    }

    /**
     * Test method for {@link net.sf.bioutils.proteomics.UtilPeak#findHighestMZ(java.lang.Iterable)} .
     */
    @Test
    public final void testFindHighestMZ01() {
        final List<PeakImpl> in = Arrays.asList(new PeakImpl(10, 10));
        assertEquals(new PeakImpl(10, 10), UtilPeak.findHighestMZ(in));
    }

    @Test
    public final void testToAbs01() {
        assertEquals(0.03, UtilPeak.getAbsDelta(1000, 30), 0);
    }

    @Test
    public final void testToAbs02() {
        assertEquals(0.09, UtilPeak.getAbsDelta(3000, 30), 0);
    }

    @Test
    public final void testToPpm01() {
        assertEquals(30, UtilPeak.getPpmDelta(1000, 0.03), 0);
    }

    @Test
    public final void testToPpm02() {
        assertEquals(30, UtilPeak.getPpmDelta(3000, 0.09), 0);
    }

}
