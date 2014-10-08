package net.sf.bioutils.proteomics.sample.stats;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SampleStatistics {

    private BigDecimal totalIntensity = BigDecimal.ZERO;

    private BigDecimal totalIntensityToNoise = BigDecimal.ZERO;

    private BigInteger numberOfPeaks = BigInteger.ZERO;

    private BigInteger numberOfPeptides = BigInteger.ZERO;

    private BigInteger numberOfProteins = BigInteger.ZERO;

    private BigInteger numberOfFeatures = BigInteger.ZERO;

    public synchronized BigInteger getNumberOfFeatures() {
        return numberOfFeatures;
    }

    public synchronized BigInteger getNumberOfPeaks() {
        return numberOfPeaks;
    }

    public synchronized BigInteger getNumberOfPeptides() {
        return numberOfPeptides;
    }

    public synchronized BigInteger getNumberOfProteins() {
        return numberOfProteins;
    }

    public synchronized BigDecimal getTotalIntensity() {
        return totalIntensity;
    }

    public synchronized BigDecimal getTotalIntensityToNoise() {
        return totalIntensityToNoise;
    }

    public synchronized void setNumberOfFeatures(final BigInteger numberOfFeatures) {
        this.numberOfFeatures = numberOfFeatures;
    }

    public synchronized void setNumberOfPeaks(final BigInteger numberOfPeaks) {
        this.numberOfPeaks = numberOfPeaks;
    }

    public synchronized void setNumberOfPeptides(final BigInteger numberOfPeptides) {
        this.numberOfPeptides = numberOfPeptides;
    }

    public synchronized void setNumberOfProteins(final BigInteger numberOfProteins) {
        this.numberOfProteins = numberOfProteins;
    }

    public synchronized void setTotalIntensity(final BigDecimal totalIntensity) {
        this.totalIntensity = totalIntensity;
    }

    public synchronized void setTotalIntensityToNoise(final BigDecimal totalIntensityToNoise) {
        this.totalIntensityToNoise = totalIntensityToNoise;
    }

}
