package net.sf.bioutils.proteomics;

/**
 * TODO description
 * <p>
 * <b>Example:</b><br>
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * <p>
 * last reviewed 2011-11-30
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2012-11-30
 */
public interface Peak {

    Fraction getFraction();

    /**
     * Shortcut for {@link Peak.getFraction().getIndex()}. </p> Can be helpful for implementations of {@code Peak} which
     * do not have a {@link Fraction}.
     * 
     * @return index of {@link Fraction} which contains this {@code peak}
     */
    int getFractionIndex();

    double getIntensity();

    double getIntensityToNoise();

    double getMz();

    double getMz(MassUnit unit);

    String getName();

    void setFraction(Fraction fraction);

}
