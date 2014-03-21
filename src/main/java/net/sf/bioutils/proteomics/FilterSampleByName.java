package net.sf.bioutils.proteomics;

import net.sf.bioutils.proteomics.sample.Sample;
import net.sf.kerner.utils.collections.filter.Filter;

public class FilterSampleByName implements Filter<Sample> {

    private String name;

    public FilterSampleByName() {
        name = null;
    }

    public FilterSampleByName(final String name) {
        this.name = name;
    }

    @Override
    public boolean filter(final Sample e) {
        return e.getName().equals(getName());
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(final String name) {
        this.name = name;
    }

}
