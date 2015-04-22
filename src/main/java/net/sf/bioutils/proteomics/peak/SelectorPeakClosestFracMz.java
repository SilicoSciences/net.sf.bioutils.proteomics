package net.sf.bioutils.proteomics.peak;

import java.util.Collection;
import java.util.TreeMap;

import net.sf.kerner.utils.collections.Selector;
import net.sf.kerner.utils.collections.UtilCollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectorPeakClosestFracMz implements Selector<Peak> {

    private final double mz;

    private final static Logger log = LoggerFactory.getLogger(SelectorPeakClosestFracMz.class);

    private final double fracNr;

    public SelectorPeakClosestFracMz(final double mz, final double fracNr) {
        this.mz = mz;
        this.fracNr = fracNr;
    }

    @Override
    public Peak select(final Collection<? extends Peak> elements) {
        if (UtilCollection.nullOrEmpty(elements)) {
            throw new IllegalArgumentException("Empty param");
        }
        if (log.isDebugEnabled() && elements.size() > 1) {
            // log.debug("Have to choose from " + elements.size());
        }
        final TreeMap<Double, Peak> map = new TreeMap<Double, Peak>();
        for (final Peak p : elements) {
            double diffAbsMz = Math.abs(p.getMz() - mz);
            diffAbsMz = UtilPeak.getDeltaPpm(mz, diffAbsMz);
            diffAbsMz = diffAbsMz / 100;
            final double diffAbsFrac = Math.abs(p.getFractionIndex() - fracNr);
            final double result = diffAbsFrac * (diffAbsMz);
            map.put(result, p);
            // map.put(diffAbsFrac, p);
        }
        return map.firstEntry().getValue();
    }
}
