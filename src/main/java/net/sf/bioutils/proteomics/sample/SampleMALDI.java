package net.sf.bioutils.proteomics.sample;

import java.util.List;

import net.sf.bioutils.proteomics.fraction.Fraction;

public interface SampleMALDI extends Sample, Iterable<Fraction> {

    /**
     *
     * Clones sample, dismissing fractions.
     *
     * @see #clone()
     */
    Sample cloneWOFractions();

    List<Fraction> getFractions();

    void setFractions(List<? extends Fraction> fraction);

}
