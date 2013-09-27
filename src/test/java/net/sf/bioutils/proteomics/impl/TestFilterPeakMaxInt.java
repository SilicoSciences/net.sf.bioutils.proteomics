package net.sf.bioutils.proteomics.impl;

import static org.junit.Assert.assertArrayEquals;

import java.util.Collection;
import java.util.List;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.peak.impl.PeakImpl;
import net.sf.bioutils.proteomics.provider.ProviderIntensity;
import net.sf.kerner.utils.collections.impl.UtilCollection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFilterPeakMaxInt {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    private FilterPeakMaxInt filter;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        filter = null;
    }

    @Test
    public final void testFilter01() {
        final Collection<? extends Peak> peaks = UtilCollection.newCollection(new PeakImpl(-1, 1), new PeakImpl(-1, 2));
        filter = new FilterPeakMaxInt(peaks, 2);
        assertArrayEquals(peaks.toArray(), UtilCollection.filterCollectionReturn(peaks, filter).toArray());

    }

    @Test
    public final void testFilter02() {
        final Collection<? extends Peak> peaks = UtilCollection.newCollection(new PeakImpl(-1, 1), new PeakImpl(-1, 2));
        filter = new FilterPeakMaxInt(peaks, 1);
        assertArrayEquals(new PeakImpl[] { new PeakImpl(-1, 2) }, UtilCollection.filterCollectionReturn(peaks, filter)
                .toArray());

    }

    @Test
    public final void testFilter03() {
        final Collection<? extends Peak> peaks = UtilCollection.newCollection(new PeakImpl(-1, 1), new PeakImpl(-1, 2),
                new PeakImpl(-1, 3));
        filter = new FilterPeakMaxInt(peaks, 2);
        final List<ProviderIntensity> col = UtilCollection.filterCollectionReturn(peaks, filter);
        // filters just by intensity. returned collection is NOT sorted by
        // intensity.
        assertArrayEquals(new PeakImpl[] { new PeakImpl(-1, 2), new PeakImpl(-1, 3) }, col.toArray());

    }
}
