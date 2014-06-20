package net.sf.bioutils.proteomics.sample.impl;

import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.kerner.utils.equal.Equalator;
import net.sf.kerner.utils.pair.Pair;

public class EqualatorSample implements Equalator<Sample> {

    @Override
    public boolean areEqual(final Sample element, final Object obj) {
        if (element == obj)
            return true;
        if (element == null)
            return false;
        if (obj == null)
            return false;
        if (!(obj instanceof Sample))
            return false;
        final Sample other = (Sample) obj;

        if (element.getName() == null) {
            if (other.getName() != null)
                return false;
        } else if (!element.getName().equals(other.getName()))
            return false;

        if (element.getUser() == null) {
            if (other.getUser() != null)
                return false;
        } else if (!element.getUser().equals(other.getUser()))
            return false;

        if (element.getProperties() == null) {
            if (other.getProperties() != null)
                return false;
        } else if (!element.getProperties().equals(other.getProperties()))
            return false;

        if (!element.getPeaks().equals(other.getPeaks()))
            return false;
        return true;
    }

    @Override
    public Boolean transform(final Pair<Sample, Object> element) {
        return areEqual(element.getFirst(), element.getSecond());
    }

}
