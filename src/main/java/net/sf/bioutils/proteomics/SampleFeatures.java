package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.fraction.FactoryFraction;
import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.sample.Sample;

/**
 * 
 * An instance of {@link Sample}, which expects fractions to be of type
 * {@link FractionFeatures}
 * 
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * <p>
 * last reviewed: 2013-08-08
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2013-08-29
 * 
 */
public class SampleFeatures extends SamplePeaks {

    public SampleFeatures(final Sample sample) {
        super(sample);

    }

    public SampleFeatures(final Sample sample, final String newName) {
        super(sample, newName);
    }

    public SampleFeatures(final String name) {
        super(name);

    }

    public SampleFeatures(final String name, final User user) {
        super(name, user);

    }

    @Override
    protected void checkFraction(final Fraction f) {
        // if (!(f instanceof FractionFeatures) && !(f instanceof
        // FractionTestable)) {
        // throw new IllegalArgumentException("wrong fraction " +
        // f.getClass().getSimpleName());
        // }
        f.setSample(this);
    }

    @Override
    public synchronized SampleFeatures clone() {
        return new SampleFeatures(this);
    }

    @Override
    public Sample clone(final String newName) {
        return new SampleFeatures(this, newName);
    }

    @Override
    protected FactoryFraction getFactoryFraction() {
        return new FactoryFractionFeatures();
    }
}
