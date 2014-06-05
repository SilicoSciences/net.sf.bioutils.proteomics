package net.sf.bioutils.proteomics.peak.impl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import net.sf.bioutils.proteomics.peak.FractionPeaks;
import net.sf.bioutils.proteomics.peak.SamplePeaks;
import net.sf.kerner.utils.pair.PairSame;
import net.sf.kerner.utils.pair.PairSameImpl;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPeakImplEqualsHashClone {

    private PeakImpl p1, p2;

    @AfterClass
    public void afterClass() {
    }

    @AfterMethod
    public void afterMethod() {
        p1 = null;
        p2 = null;
    }

    @AfterTest
    public void afterTest() {
    }

    @BeforeClass
    public void beforeClass() {
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @BeforeTest
    public void beforeTest() {
    }

    private PairSame<PeakImpl> getPeaksForEqualsHash01() {
        p1 = new PeakImpl(1, 1);
        p2 = new PeakImpl(1, 1);
        return new PairSameImpl<PeakImpl>(p1, p2);
    }

    private PairSame<PeakImpl> getPeaksForEqualsHash02() {
        p1 = new PeakImpl(1, 1);
        p2 = new PeakImpl(2, 2);
        return new PairSameImpl<PeakImpl>(p1, p2);
    }

    private PairSame<PeakImpl> getPeaksForEqualsHash03() {
        p1 = new PeakImpl(1, 1);
        p1.setFraction(new FractionPeaks(null));
        p2 = new PeakImpl(1, 1);
        p2.setFraction(new FractionPeaks(null));
        return new PairSameImpl<PeakImpl>(p1, p2);
    }

    private PairSame<PeakImpl> getPeaksForEqualsHash04() {
        p1 = new PeakImpl(1, 1);
        p1.setFraction(new FractionPeaks(null));
        p2 = new PeakImpl(1, 1);
        // p2.setFraction(new FractionPeaks(null));
        return new PairSameImpl<PeakImpl>(p1, p2);
    }

    private PairSame<PeakImpl> getPeaksForEqualsHash05() {
        final SamplePeaks s = new SamplePeaks("s");
        p1 = new PeakImpl(1, 1);
        p1.setFraction(new FractionPeaks(null));
        p2 = new PeakImpl(1, 1);
        p2.setFraction(new FractionPeaks(null));
        s.addFraction(p2.getFraction());
        return new PairSameImpl<PeakImpl>(p1, p2);
    }

    private PairSame<PeakImpl> getPeaksForEqualsHash06() {
        p1 = new PeakImpl(1409.70105, 167.0);
        p2 = new PeakImpl(1409.7011, 167.0);
        return new PairSameImpl<PeakImpl>(p1, p2);
    }

    @Test
    public void testClone01() {
        p1 = new PeakImpl(1, 1);
        p2 = p1.clone();
        assertEquals(p1.getFraction(), p2.getFraction());
        assertEquals(p1.getIntensity(), p2.getIntensity());
        assertEquals(p1.getIntensityToNoise(), p2.getIntensityToNoise());
        assertEquals(p1.getMz(), p2.getMz());
        assertEquals(p1.getName(), p2.getName());
        // assertEquals(p1.getSample(), p2.getSample());
    }

    @Test
    public void testClone02() {
        p1 = new PeakImpl("test", 2, 2, 2);
        p2 = p1.clone();
        assertEquals(p1.getFraction(), p2.getFraction());
        assertEquals(p1.getIntensity(), p2.getIntensity());
        assertEquals(p1.getIntensityToNoise(), p2.getIntensityToNoise());
        assertEquals(p1.getMz(), p2.getMz());
        assertEquals(p1.getName(), p2.getName());
        // assertEquals(p1.getSample(), p2.getSample());
    }

    @Test
    public void testClone03() {
        p1 = new PeakImpl("test", 2, 2, 2);
        final SamplePeaks s = new SamplePeaks("test");
        final FractionPeaks f = new FractionPeaks();
        f.addPeak(p1);
        s.addFraction(f);
        p2 = p1.clone();
        assertEquals(p1.getFraction(), p2.getFraction());
        assertEquals(p1.getIntensity(), p2.getIntensity());
        assertEquals(p1.getIntensityToNoise(), p2.getIntensityToNoise());
        assertEquals(p1.getMz(), p2.getMz());
        assertEquals(p1.getName(), p2.getName());
        // assertEquals(p1.getSample(), p2.getSample());
    }

    @Test
    public void testEquals01() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash01();
        assertEquals(pair.getFirst(), pair.getSecond());
    }

    @Test
    public void testEquals02() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash02();
        assertNotEquals(pair.getFirst(), pair.getSecond());
    }

    @Test
    public void testEquals03() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash03();
        assertEquals(pair.getFirst(), pair.getSecond());
    }

    @Test
    public void testEquals04() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash04();
        assertNotEquals(pair.getFirst(), pair.getSecond());
    }

    @Test
    public void testEquals05() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash05();
        assertNotEquals(pair.getFirst(), pair.getSecond());
    }

    @Test
    public void testEquals06() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash06();
        assertEquals(pair.getFirst(), pair.getSecond());
    }

    @Test
    public void testHashCode01() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash01();
        assertEquals(pair.getFirst().hashCode(), pair.getSecond().hashCode());
    }

    @Test
    public void testHashCode02() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash02();
        assertNotEquals(pair.getFirst().hashCode(), pair.getSecond().hashCode());
    }

    @Test
    public void testHashCode03() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash03();
        assertEquals(pair.getFirst().hashCode(), pair.getSecond().hashCode());
    }

    @Test
    public void testHashCode04() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash04();
        assertNotEquals(pair.getFirst().hashCode(), pair.getSecond().hashCode());
    }

    @Test
    public void testHashCode05() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash05();
        assertNotEquals(pair.getFirst().hashCode(), pair.getSecond().hashCode());
    }

    @Test
    public void testHashCode06() {
        final PairSame<PeakImpl> pair = getPeaksForEqualsHash06();
        assertNotEquals(pair.getFirst().hashCode(), pair.getSecond().hashCode());
    }
}
