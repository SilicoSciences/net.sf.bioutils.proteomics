package net.sf.bioutils.proteomics.sample.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.sample.Sample;

public class UtilSample {

    // private final static Logger log =
    // LoggerFactory.getLogger(UtilSample.class);

    public static List<Sample> clone(final List<Sample> samples) {
        final List<Sample> result = new ArrayList<Sample>(samples.size());
        for (final Sample s : samples) {
            result.add(s.clone());
        }
        return result;
    }

}
