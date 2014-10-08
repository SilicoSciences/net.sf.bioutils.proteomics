package net.sf.bioutils.proteomics.sample.stats;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.Callable;

import net.sf.bioutils.proteomics.feature.Feature;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.kerner.utils.collections.list.impl.ListWalkerDefault;

public class SampleStatisticsCallable extends ListWalkerDefault<Peak> implements
        Callable<SampleStatistics> {

    protected final Sample sample;
    protected final SampleStatistics result = new SampleStatistics();

    public SampleStatisticsCallable(final Sample sample) {
        this.sample = sample;
    }

    @Override
    public synchronized SampleStatistics call() throws Exception {
        walk(sample.getPeaks());
        return result;
    }

    @Override
    public synchronized void visit(final Peak p, final int index) {
        if (p instanceof Feature) {
            result.setNumberOfFeatures(result.getNumberOfFeatures().add(BigInteger.ONE));
            final Feature f = (Feature) p;
            result.setNumberOfPeaks(result.getNumberOfPeaks().add(
                    BigInteger.valueOf(f.getMembers().size())));
        } else {
            result.setNumberOfPeaks(result.getNumberOfPeaks().add(BigInteger.ONE));
        }
        result.setTotalIntensity(result.getTotalIntensity().add(new BigDecimal(p.getIntensity())));
        result.setTotalIntensityToNoise(result.getTotalIntensityToNoise().add(
                new BigDecimal(p.getIntensityToNoise())));
    }
}
