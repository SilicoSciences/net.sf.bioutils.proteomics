package net.sf.bioutils.proteomics.comparator;

import java.util.Comparator;

import net.sf.bioutils.proteomics.provider.ProviderIntensity;
import net.sf.kerner.utils.collections.ComparatorNull;

public class ComparatorIntensity extends ComparatorNull<ProviderIntensity> implements
        Comparator<ProviderIntensity> {

    @Override
    public int compareNonNull(final ProviderIntensity o1, final ProviderIntensity o2) {
        return Double.valueOf(o1.getIntensity()).compareTo(o2.getIntensity());

    }
}
