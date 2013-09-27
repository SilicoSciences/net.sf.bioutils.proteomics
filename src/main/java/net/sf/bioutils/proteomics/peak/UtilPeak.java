package net.sf.bioutils.proteomics.peak;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import net.sf.bioutils.proteomics.impl.ComparatorPeakByMZ;
import net.sf.bioutils.proteomics.impl.FilterPeakBySignalToNoise;
import net.sf.bioutils.proteomics.impl.TransformerPeakToFractionNr;
import net.sf.bioutils.proteomics.impl.comparator.ComparatorIntensity;
import net.sf.kerner.utils.Transformer;
import net.sf.kerner.utils.collections.filter.Filter;
import net.sf.kerner.utils.collections.impl.ComparatorInverter;
import net.sf.kerner.utils.collections.impl.UtilCollection;
import net.sf.kerner.utils.collections.list.impl.UtilList;

public class UtilPeak {

    public static List<Peak> filter(final List<? extends Peak> peaks, final Filter<Peak> filter) {
        return UtilList.filterList(peaks, filter);
    }

    public static List<Peak> filterBySignalToNoise(final List<Peak> peaks, final double snRatio, final boolean above) {
        FilterPeakBySignalToNoise.Type type = FilterPeakBySignalToNoise.Type.BELOW;
        if (above) {
            type = FilterPeakBySignalToNoise.Type.ABOVE;
        }
        return filter(peaks, new FilterPeakBySignalToNoise(snRatio, type));
    }

    public static <T extends Peak> T findClosestToIntensity(final Iterable<T> peaks, final int intensity) {
        T result = null;
        for (final T p : peaks) {
            if (result == null)
                result = p;
            else {
                final double intDiffNew = Math.abs(intensity - p.getIntensity());

                // TODO cache this
                final double intDiffOld = Math.abs(intensity - result.getIntensity());

                if (intDiffNew < intDiffOld) {
                    result = p;
                }
            }
        }
        return result;
    }

    public static <T extends Peak> T findClosestToMZ(final Iterable<T> peaks, final double mass) {
        T result = null;
        for (final T p : peaks) {
            if (result == null)
                result = p;
            else {
                final double massDiffNew = Math.abs(mass - p.getMz());

                // TODO cache this
                final double massDiffOld = Math.abs(mass - result.getMz());

                if (massDiffNew < massDiffOld) {
                    result = p;
                }
            }
        }
        return result;
    }

    public static <T extends Peak> T findHighestIntensity(final Iterable<T> peaks) {
        final List<T> copy = new ArrayList<T>();
        for (final T p : peaks) {
            copy.add(p);
        }
        if (copy.isEmpty())
            return null;
        Collections.sort(copy, new ComparatorIntensity());
        return copy.get(copy.size() - 1);
    }

    public static <T extends Peak> T findHighestMZ(final Iterable<T> peaks) {
        final List<T> copy = new ArrayList<T>();
        for (final T p : peaks) {
            copy.add(p);
        }
        if (copy.isEmpty())
            return null;
        Collections.sort(copy, new ComparatorPeakByMZ());
        return copy.get(copy.size() - 1);
    }

    /**
     * Converts an PPM delta to according absolute delta.
     * 
     * @param parent
     * @param ppmDelta
     * @return converted delta
     */
    public static double getAbsDelta(final double parent, final double ppmDelta) {
        return ppmDelta * parent / 1.0E+6;
    }

    /**
     * Converts an absolute delta to according PPM delta.
     * 
     * @param parent
     * @param absDelta
     * @return converted delta
     */
    public static double getPpmDelta(final double parent, final double absDelta) {
        return 1.0E+6 * absDelta / parent;
    }

    public static double getPpmDeltaMz(final Peak p1, final Peak p2) {
        final double absDiff = Math.abs(p1.getMz() - p2.getMz());
        return getPpmDelta(p1.getMz(), absDiff);
    }

    public static TreeMap<Double, Peak> getSortedMapMassShiftAbsSmallestFirst(final double mass,
            final Collection<? extends Peak> values) {
        final TreeMap<Double, Peak> result = new TreeMap<Double, Peak>();

        for (final Peak p : values) {
            result.put(Math.abs(mass - p.getMz()), p);
        }
        return result;
    }

    public static TreeMap<Double, Peak> getSortedMapMassShiftAbsSmallestFirst(final Peak key,
            final Collection<? extends Peak> values) {
        return getSortedMapMassShiftAbsSmallestFirst(key.getMz(), values);
    }

    public static TreeSet<Peak> getSortedSet(final Collection<? extends Peak> peaks, final Comparator<Peak> comparator) {
        final TreeSet<Peak> result = new TreeSet<Peak>(comparator);
        result.addAll(peaks);
        return result;
    }

    public static TreeSet<Peak> getSortedSetByMzLargestFirst(final Collection<? extends Peak> peaks) {
        return getSortedSet(peaks, new ComparatorInverter<Peak>(new ComparatorPeakByMZ()));
    }

    public static TreeSet<Peak> getSortedSetByMzSmallestFirst(final Collection<? extends Peak> peaks) {
        return getSortedSet(peaks, new ComparatorPeakByMZ());
    }

    @Deprecated
    public static String intensityToNoiseToString(final Peak peak) {
        return String.format("%3.0f", peak.getIntensityToNoise());
    }

    @Deprecated
    public static String intensityToString(final double intensity) {
        return String.format("%3.0f", intensity);
    }

    @Deprecated
    public static String intensityToString(final Peak peak) {
        return intensityToString(peak.getIntensity());
    }

    @Deprecated
    public static String mzToString(final double mz) {
        return String.format("%4.4f", mz);
    }

    @Deprecated
    public static String mzToString(final Peak peak) {
        return mzToString(peak.getMz());
    }

    @Deprecated
    public static String ppmToString(final double ppm) {
        return String.format("%6.2f", ppm);
    }

    public static String toStringIndices(final Collection<? extends Peak> peaks) {
        return UtilCollection.toString(new TransformerPeakToFractionNr().transformCollection(peaks));
    }

    public static String toStringNames(final Collection<? extends Peak> peaks) {
        return UtilCollection.toString(new ArrayList<Peak>(peaks), new Transformer<Peak, String>() {
            @Override
            public String transform(final Peak element) {
                return element.getName();
            }
        });
    }

    private UtilPeak() {
    }

}
