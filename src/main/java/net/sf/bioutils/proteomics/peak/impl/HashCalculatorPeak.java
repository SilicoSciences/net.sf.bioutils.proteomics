package net.sf.bioutils.proteomics.peak.impl;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.hash.HashCalculatorAbstract;

public class HashCalculatorPeak extends HashCalculatorAbstract<Peak> {

    /**
     * Calculates hash code based on m/z and fraction index.
     */
    @Override
    public int calculateHash(final Peak element) {
        synchronized (element) {
            int result = 95419;
            final int prime = 74551;
            long temp;
            temp = Double.doubleToLongBits(element.getMz());
            result = prime * result + (int) (temp ^ (temp >>> 32));
            result = prime * result + element.getFractionIndex();
            // if (element instanceof Feature) {
            // result = prime * result + ((Feature) element).getFirstIndex();
            // result = prime * result + ((Feature) element).getLastIndex();
            // }
            return result;
        }
    }

    @Override
    public Integer transform(final Peak element) {
        return Integer.valueOf(calculateHash(element));
    }

}
