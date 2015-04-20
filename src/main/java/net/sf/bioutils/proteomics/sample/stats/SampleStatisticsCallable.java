package net.sf.bioutils.proteomics.sample.stats;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import net.sf.bioutils.proteomics.feature.Feature;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.kerner.utils.collections.list.ListWalkerDefault;

public class SampleStatisticsCallable extends ListWalkerDefault<Peak> implements
        Callable<SampleStatistics> {

    protected final Sample sample;
    protected SampleStatistics result;

    public SampleStatisticsCallable(final Sample sample) {
        this.sample = sample;
        result = new SampleStatistics();
    }

    @Override
    public synchronized SampleStatistics call() {
        sample.getLock().readLock().lock();
        try {
            walk(sample.getPeaks());
        } finally {
            sample.getLock().readLock().unlock();
        }
        return result;
    }

    @Override
    public synchronized void visit(final Peak p, final int index) {

        // PeakBean implements Feature
        // if (p instanceof Feature) {

        if (p instanceof Feature && ((Feature) p).getMembers().size() > 1) {
            result.incrementNumberOfFeatures();
            final Feature f = (Feature) p;
            result.setNumberOfPeaks(result.getNumberOfPeaks() + f.getMembers().size());
            for (final Peak pp : ((Feature) p).getMembers()) {
                if (result.getMaxPeakInt() < pp.getIntensity()) {
                    result.setMaxPeakInt(pp.getIntensity());
                }
                if (result.getMaxPeakSN() < pp.getIntensityToNoise()) {
                    result.setMaxPeakSN(pp.getIntensityToNoise());
                }
                if (result.getMaxPeakMz() < pp.getMz()) {
                    result.setMaxPeakSN(pp.getMz());
                }
            }
        } else {
            result.incrementNumberOfPeaks();
            if (result.getMaxPeakInt() < p.getIntensity()) {
                result.setMaxPeakInt(p.getIntensity());
            }
            if (result.getMaxPeakSN() < p.getIntensityToNoise()) {
                result.setMaxPeakSN(p.getIntensityToNoise());
            }
            if (result.getMaxPeakMz() < p.getMz()) {
                result.setMaxPeakSN(p.getMz());
            }
        }
        result.setTotalIntensity(result.getTotalIntensity().add(new BigDecimal(p.getIntensity())));
        result.setTotalIntensityToNoise(result.getTotalIntensityToNoise().add(
                new BigDecimal(p.getIntensityToNoise())));

    }
}
