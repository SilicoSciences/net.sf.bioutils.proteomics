package net.sf.bioutils.proteomics.sample;

import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.fraction.FractionBean;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.kerner.utils.transformer.Transformer;

public class TrasformerSample2Fractions implements Transformer<Sample, List<Fraction>> {

    private Fraction getFraction(final Sample sample, final int fractionIndex,
            final List<Fraction> result) {
        if (result.size() > fractionIndex) {
            return result.get(fractionIndex);
        }
        for (int i = result.size(); i <= fractionIndex; i++) {
            result.add(new FractionBean(sample, i));
        }
        return result.get(fractionIndex);
    }

    @Override
    public List<Fraction> transform(final Sample element) {
        final ArrayList<Fraction> result = new ArrayList<Fraction>();
        element.getLock().readLock().lock();
        try {
            for (final Peak p : element.getPeaks()) {
                final Fraction f = getFraction(element, p.getFractionIndex(), result);
                f.addPeak(p);
            }
            result.trimToSize();
            return result;
        } finally {
            element.getLock().readLock().unlock();
        }
    }

}
