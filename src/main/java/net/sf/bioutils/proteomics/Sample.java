package net.sf.bioutils.proteomics;

import java.util.List;

public interface Sample extends AnnotatableElement<Object>, Iterable<Fraction> {

    Sample clone();

    List<Fraction> getFractions();

    String getName();

    User getParent();

    void setFractions(List<? extends Fraction> fraction);

}
