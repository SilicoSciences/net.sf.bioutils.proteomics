package net.sf.bioutils.proteomics;

import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public interface Sample extends AnnotatableElement, Iterable<Fraction> {

    void addAllSampleGroups(Collection<? extends SampleGroup> sampleGroups);

    void addSampleGroup(SampleGroup sampleGroup);

    void clearSampleGroups();

    Sample clone();

    List<Fraction> getFractions();

    String getName();

    Sample getParent();

    Properties getProperties();

    Set<SampleGroup> getSampleGroups();

    User getUser();

    void setFractions(List<? extends Fraction> fraction);

}
