package net.sf.bioutils.proteomics.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.jranges.range.doublerange.DoubleRange;
import net.sf.jranges.range.doublerange.impl.FactoryRangeDoubleZeroPositive;
import net.sf.jranges.range.doublerange.impl.RangeDoubleUtils;
import net.sf.jranges.range.doublerange.impl.ZeroPositiveDoubleRange;
import net.sf.kerner.utils.collections.map.MapList;

public class SampleViews {

    public static DoubleRange findRangeMZ(final Peak peak,
            final Collection<? extends DoubleRange> ranges) {
        for (final DoubleRange r : ranges) {
            if (r.includes(peak.getMz())) {
                return r;
            }
        }
        throw new RuntimeException("could not find valid range for " + peak);
    }

    public static MapList<DoubleRange, Peak> getBinningMZ(
            final Collection<? extends DoubleRange> ranges, final Collection<? extends Peak> peaks) {
        final MapList<DoubleRange, Peak> result = new MapList<DoubleRange, Peak>();
        for (final Peak p : peaks) {
            result.put(findRangeMZ(p, ranges), p);
        }
        return result;
    }

    public static List<Peak> getPeaks(final MapList<DoubleRange, Peak> bins, final double mz) {
        for (final Entry<DoubleRange, List<Peak>> e : bins.entrySet()) {
            if (e.getKey().includes(mz)) {
                return e.getValue();
            }
        }
        return null;
    }

    public static MapList<DoubleRange, Peak> getViewMassRanges(
            final Collection<? extends Peak> peaks) {

        final DoubleRange range = new ZeroPositiveDoubleRange(130.5655, 10254.6250, 1.0005);

        final ArrayList<DoubleRange> split = new ArrayList<DoubleRange>(RangeDoubleUtils.split(
                range, 6, new FactoryRangeDoubleZeroPositive()));

        final MapList<DoubleRange, Peak> result = getBinningMZ(split, peaks);

        return result;

    }

    private SampleViews() {

    }

}
