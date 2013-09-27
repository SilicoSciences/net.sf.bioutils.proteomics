package net.sf.bioutils.proteomics.impl.comparator;

import java.util.Comparator;

import net.sf.bioutils.proteomics.provider.ProviderIntensity;
import net.sf.kerner.utils.collections.impl.ComparatorNull;

public class ComparatorIntensity extends ComparatorNull<ProviderIntensity> implements
        Comparator<ProviderIntensity> {

    @Override
    public int compareNonNull(final ProviderIntensity o1, final ProviderIntensity o2) {
        return Double.compare(o1.getIntensity(), o2.getIntensity());

    }

}
