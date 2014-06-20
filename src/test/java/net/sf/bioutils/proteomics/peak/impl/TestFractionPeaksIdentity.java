package net.sf.bioutils.proteomics.peak.impl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import net.sf.bioutils.proteomics.peak.FractionPeaks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestFractionPeaksIdentity {

    private FractionPeaks f1, f2;

    @AfterMethod
    public void afterMethod() {
        f1 = null;
        f2 = null;
    }

    @Test
    public void testIdentity01() {

        // Fraction must never be same, since sample#indexof

        f1 = new FractionPeaks();
        f2 = f1;
        assertEquals(f1, f2);
        assertEquals(f1.hashCode(), f2.hashCode());
    }

    @Test
    public void testIdentity02() {

        // Fraction must never be same, since sample#indexof

        f1 = new FractionPeaks();
        f2 = new FractionPeaks();
        assertNotEquals(f1, f2);
        assertNotEquals(f1.hashCode(), f2.hashCode());
    }

    @Test
    public void testIdentity03() {

        // Fraction must never be same, since sample#indexof

        f1 = new FractionPeaks();
        f1.addPeak(new PeakImpl(1, 1));
        f2 = new FractionPeaks();
        f2.addPeak(new PeakImpl(1, 1));
        assertNotEquals(f1, f2);
        assertNotEquals(f1.hashCode(), f2.hashCode());
    }

    @Test
    public void testIdentity04() {

        // Fraction must never be same, since sample#indexof

        f1 = new FractionPeaks();
        f1.addPeak(new PeakImpl("gg", 1, 1, 2));
        f2 = new FractionPeaks();
        f2.addPeak(new PeakImpl("ff", 1, 1, 3));
        assertNotEquals(f1, f2);
        assertNotEquals(f1.hashCode(), f2.hashCode());
    }

}
