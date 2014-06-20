package net.sf.bioutils.proteomics.peak.impl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.Arrays;

import net.sf.bioutils.proteomics.peak.FractionPeaks;
import net.sf.bioutils.proteomics.peak.SamplePeaks;
import net.sf.bioutils.proteomics.peak.impl.PeakImpl;
import net.sf.bioutils.proteomics.sample.Sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSamplePeaks {

    private Sample s1, s2;

    @AfterClass
    public void afterClass() {
    }

    @AfterTest
    public void afterTest() {
        s1 = s2 = null;
    }

    @BeforeClass
    public void beforeClass() {
    }

    @BeforeTest
    public void beforeTest() {
    }

    @Test
    public void tesetHashCode01() {
        s1 = new SamplePeaks("s");
        s2 = new SamplePeaks("s");
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void tesetHashCode01b() {
        s1 = new SamplePeaks("s");
        s2 = new SamplePeaks("s2");
        assertNotEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void tesetHashCode02() {
        s1 = new SamplePeaks("s");
        s1.setFractions(Arrays.asList(new FractionPeaks()));
        s2 = new SamplePeaks("s");
        s2.setFractions(Arrays.asList(new FractionPeaks()));
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void tesetHashCode03() {
        s1 = new SamplePeaks("s");
        s1.setFractions(Arrays.asList(new FractionPeaks()));
        s2 = new SamplePeaks("s");
        // fraction names not considered
        s2.setFractions(Arrays.asList(new FractionPeaks("f")));
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void testClone01() {

    }

    @Test
    public void testCloneString01() {

    }

    @Test
    public void testCloneWOFractions01() {

    }

    @Test
    public void testEquals01() {
        s1 = new SamplePeaks("s");
        s2 = new SamplePeaks("s");
        assertEquals((Object) s1, s2);
    }

    @Test
    public void testEquals01b() {
        s1 = new SamplePeaks("s");
        s2 = new SamplePeaks("s2");
        assertNotEquals(s1, s2);
    }

    @Test
    public void testEquals02() {
        s1 = new SamplePeaks("s");
        s1.setFractions(Arrays.asList(new FractionPeaks("f")));
        s2 = new SamplePeaks("s");
        s2.setFractions(Arrays.asList(new FractionPeaks("f")));
        assertEquals((Object) s1, s2);
    }

    @Test
    public void testEquals03() {
        s1 = new SamplePeaks("s");
        s1.setFractions(Arrays.asList(new FractionPeaks("f")));
        s2 = new SamplePeaks("s");
        // fraction names not considered
        s2.setFractions(Arrays.asList(new FractionPeaks("ff")));
        assertEquals((Object) s1, s2);
    }

    @Test
    public void testEquals04() {
        s1 = new SamplePeaks("s");
        final FractionPeaks fp1 = new FractionPeaks();
        final FractionPeaks fp2 = new FractionPeaks();
        fp1.addPeak(new PeakImpl(1, 1));
        fp2.addPeak(new PeakImpl(1, 1));
        s1.setFractions(Arrays.asList(fp1));
        s2 = new SamplePeaks("s");
        // fraction names not considered
        s2.setFractions(Arrays.asList(fp2));
        assertEquals((Object) s1, s2);
    }

    @Test
    public void testEquals05() {
        s1 = new SamplePeaks("s");
        final FractionPeaks fp1 = new FractionPeaks();
        final FractionPeaks fp2 = new FractionPeaks();
        fp1.addPeak(new PeakImpl(1, 1));
        fp2.addPeak(new PeakImpl(2, 2));
        s1.setFractions(Arrays.asList(fp1));
        s2 = new SamplePeaks("s");
        // fraction names not considered
        s2.setFractions(Arrays.asList(fp2));
        assertNotEquals(s1, s2);
    }

    @Test
    public void testHashCode04() {
        s1 = new SamplePeaks("s");
        final FractionPeaks fp1 = new FractionPeaks();
        final FractionPeaks fp2 = new FractionPeaks();
        fp1.addPeak(new PeakImpl(1, 1));
        fp2.addPeak(new PeakImpl(1, 1));
        s1.setFractions(Arrays.asList(fp1));
        s2 = new SamplePeaks("s");
        // fraction names not considered
        s2.setFractions(Arrays.asList(fp2));
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void testHashCode05() {
        s1 = new SamplePeaks("s");
        final FractionPeaks fp1 = new FractionPeaks();
        final FractionPeaks fp2 = new FractionPeaks();
        fp1.addPeak(new PeakImpl(1, 1));
        fp2.addPeak(new PeakImpl(2, 2));
        s1.setFractions(Arrays.asList(fp1));
        s2 = new SamplePeaks("s");
        // fraction names not considered
        s2.setFractions(Arrays.asList(fp2));
        assertNotEquals(s1.hashCode(), s2.hashCode());
    }
}
