package net.sf.bioutils.proteomics.impl;

import java.util.Collection;

import net.sf.kerner.utils.collections.Equalator;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterEqual<T> implements Filter<T> {

    private final Collection<? extends T> elements;

    private final Equalator<T> equalator;

    public FilterEqual(final Collection<? extends T> elements, final Equalator<T> equalator) {
        super();
        this.elements = elements;
        this.equalator = equalator;
    }

    public boolean filter(final T e) {
        for (final T o : elements) {
            if (o.hashCode() == e.hashCode()) {
                continue;
            }
            if (equalator.areEqual(e, o)) {
                return true;
            }
        }
        return false;
    }

}
