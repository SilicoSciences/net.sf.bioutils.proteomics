package net.sf.bioutils.proteomics.sample;

import net.sf.bioutils.proteomics.fraction.Fraction;

public interface SampleMALDIModifiable extends SampleMALDI, SampleModifiable {

    /**
     *
     * @param fraction
     *            {@link Fraction} to add to this {@code Sample}
     */
    void addFraction(Fraction fraction);

}
