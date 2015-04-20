package net.sf.bioutils.proteomics.sample.stats;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SampleStatistics {

    private BigDecimal totalIntensity = BigDecimal.ZERO;

    private BigDecimal totalIntensityToNoise = BigDecimal.ZERO;

    private long numberOfPeaks = 0;

    private long numberOfFeatures = 0;

    private double medianPeakMz;

    private double maxPeakMz;

    private double maxPeakInt;

    private double maxPeakSN;

    private double medianPeakIntensity;

    private double medianPeakSn;

    public synchronized double getMaxPeakInt() {
        return maxPeakInt;
    }

    public synchronized double getMaxPeakMz() {
        return maxPeakMz;
    }

    public synchronized double getMaxPeakSN() {
        return maxPeakSN;
    }

    public synchronized double getMeanPeakIntensity() {
        if (getTotalIntensity().equals(BigDecimal.ZERO)) {
            return 0;
        }
        return getTotalIntensity().divide(BigDecimal.valueOf(numberOfPeaks), 6,
                RoundingMode.HALF_UP).doubleValue();
    }

    public synchronized double getMeanPeakSN() {
        if (getTotalIntensityToNoise().equals(BigDecimal.ZERO)) {
            return 0;
        }
        return getTotalIntensityToNoise().divide(BigDecimal.valueOf(numberOfPeaks), 6,
                RoundingMode.HALF_UP).doubleValue();
    }

    public synchronized double getMedianPeakIntensity() {
        return medianPeakIntensity;
    }

    public synchronized double getMedianPeakMz() {
        return medianPeakMz;
    }

    public synchronized double getMedianPeakSn() {
        return medianPeakSn;
    }

    public synchronized long getNumberOfFeatures() {
        return numberOfFeatures;
    }

    public synchronized long getNumberOfPeaks() {
        return numberOfPeaks;
    }

    public synchronized BigDecimal getTotalIntensity() {
        return totalIntensity;
    }

    public synchronized BigDecimal getTotalIntensityToNoise() {
        return totalIntensityToNoise;
    }

    public synchronized void incrementNumberOfFeatures() {
        numberOfFeatures++;
    }

    public synchronized void incrementNumberOfPeaks() {
        numberOfPeaks++;
    }

    public synchronized void setMaxPeakInt(final double maxPeakInt) {
        this.maxPeakInt = maxPeakInt;
    }

    public synchronized void setMaxPeakMz(final double maxPeakMz) {
        this.maxPeakMz = maxPeakMz;
    }

    public synchronized void setMaxPeakSN(final double maxPeakSN) {
        this.maxPeakSN = maxPeakSN;
    }

    public synchronized void setMedianPeakIntensity(final double medianPeakIntensity) {
        this.medianPeakIntensity = medianPeakIntensity;
    }

    public synchronized void setMedianPeakMz(final double medianPeakMz) {
        this.medianPeakMz = medianPeakMz;
    }

    public synchronized void setMedianPeakSn(final double medianPeakSn) {
        this.medianPeakSn = medianPeakSn;
    }

    public synchronized void setNumberOfFeatures(final long numberOfFeatures) {
        this.numberOfFeatures = numberOfFeatures;
    }

    public synchronized void setNumberOfPeaks(final long numberOfPeaks) {
        this.numberOfPeaks = numberOfPeaks;
    }

    public synchronized void setTotalIntensity(final BigDecimal totalIntensity) {
        this.totalIntensity = totalIntensity;
    }

    public synchronized void setTotalIntensityToNoise(final BigDecimal totalIntensityToNoise) {
        this.totalIntensityToNoise = totalIntensityToNoise;
    }

}
