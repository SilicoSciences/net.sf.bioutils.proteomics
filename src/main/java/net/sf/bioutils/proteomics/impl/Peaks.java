package net.sf.bioutils.proteomics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import net.sf.bioutils.proteomics.Peak;
import net.sf.kerner.utils.impl.util.Util;
import net.sf.kerner.utils.time.StopWatch;
import net.sf.kerner.utils.time.TimePeriod;

public class Peaks extends ArrayList<Peak> {

    private static final long serialVersionUID = 4837095714315079608L;

    private int cacheHash;

    public Peaks() {
        super();
    }

    public Peaks(final Collection<? extends Peak> c) {
        super(c);
    }

    public Peaks(final int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public boolean equals(final Object o) {
        return Util.equalsOnHashCode(this, o);
    }

    @Override
    public synchronized int hashCode() {
        int result = cacheHash;
        if (result == 0) {
            final StopWatch w = new StopWatch();
            w.start();
            result = super.hashCode();
            final TimePeriod du = w.stop();
            System.err.println("calc hash took " + du.getDuration(TimeUnit.MILLISECONDS) + "ms");
            cacheHash = result;
        }
        return result;
    }

}
