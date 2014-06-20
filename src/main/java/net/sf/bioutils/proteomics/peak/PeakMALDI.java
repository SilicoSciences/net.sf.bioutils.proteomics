package net.sf.bioutils.proteomics.peak;

import net.sf.bioutils.proteomics.fraction.Fraction;
import net.sf.bioutils.proteomics.fraction.FractionModifiable;
import net.sf.bioutils.proteomics.provider.ProviderFractionIndex;

public interface PeakMALDI extends Peak, ProviderFractionIndex {

    /**
     * Returns {@link Fraction} which contains this {@code Peak}; or
     * {@code null} if this {@code Peak} is not contained in any
     * {@link Fraction}
     *
     * @return {@link Fraction} which contains this {@code Peak}; or
     *         {@code null} if this {@code Peak} is not contained in any
     *         {@link Fraction}
     */
    Fraction getFraction();

    /**
     * Shortcut for {@code Peak.getFraction().getIndex()}.
     *
     * @return index of {@link Fraction} which contains this {@code Peak}; or
     *         {@code -1} if his {@code Peak} is not contained in any
     *         {@link Fraction}
     */
    @Override
    int getFractionIndex();

    /**
     * Returns name of {@link Fraction} which contains this {@code Peak}; or
     * {@code null} if this {@code Peak} is not contained in any
     * {@link Fraction}
     *
     * @return name of {@link Fraction} which contains this {@code Peak}; or
     *         {@code null} if this {@code Peak} is not contained in any
     *         {@link Fraction}
     */
    String getFractionName();

    /**
     * Sets the {@link Fraction} which contains this {@code Peak}. </br>
     * Typically, this method is called by {@link Fraction} itself!
     *
     * @param fraction
     *            {@link Fraction}, which contains this {@code Peak}
     *
     * @see FractionModifiable#addPeak(Peak)
     */
    void setFraction(Fraction fraction);

}
