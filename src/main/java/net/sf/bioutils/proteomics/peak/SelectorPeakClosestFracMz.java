package net.sf.bioutils.proteomics.peak;

import java.util.Collection;
import java.util.TreeMap;

import net.sf.kerner.utils.collections.Selector;
import net.sf.kerner.utils.collections.UtilCollection;

public class SelectorPeakClosestFracMz implements Selector<Peak> {

    private final double mz;

    private final int fracNr;

    public SelectorPeakClosestFracMz(final double mz, final int fracNr) {
        this.mz = mz;
        this.fracNr = fracNr;
    }

    @Override
    public Peak select(final Collection<? extends Peak> elements) {
        if (UtilCollection.nullOrEmpty(elements)) {
            throw new IllegalArgumentException("Empty param");
        }
        final TreeMap<Double, Peak> map = new TreeMap<Double, Peak>();
        for (final Peak p : elements) {
            final double diffAbsMz = Math.abs(p.getMz() - mz);
            final double diffAbsFrac = Math.abs(p.getFractionIndex() - fracNr);
            // map.put(diffAbsFrac * diffAbsMz, p);
            map.put(diffAbsFrac, p);
        }
        return map.firstEntry().getValue();
    }
}
