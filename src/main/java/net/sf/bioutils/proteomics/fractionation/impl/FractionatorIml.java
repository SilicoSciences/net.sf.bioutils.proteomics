package net.sf.bioutils.proteomics.fractionation.impl;

import java.util.Collections;
import java.util.List;

import net.sf.bioutils.proteomics.AminoAcid;
import net.sf.bioutils.proteomics.Peptide;
import net.sf.bioutils.proteomics.fractionation.Fractionator;
import net.sf.bioutils.proteomics.impl.PeptideSequenceChargedSingle;
import net.sf.kerner.utils.collections.list.impl.UtilList;

public class FractionatorIml implements Fractionator {

    public FractionatorIml() {

    }

    @Override
    public List<Peptide> fractionate(final Peptide peptide) {
        final List<Peptide> bIons = UtilList.newList();
        final List<Peptide> yIons = UtilList.newList();

        for (int i = 1; i <= peptide.asList().size(); i++) {
            bIons.add(new PeptideSequenceChargedSingle("b" + i, peptide.asList().subList(0, i)));
        }

        final List<AminoAcid> copy = UtilList.newList(peptide.asList());
        Collections.reverse(copy);

        for (int i = 1; i <= copy.size(); i++) {
            yIons.add(new PeptideSequenceChargedSingle("y" + i, copy.subList(0, i)));
        }

        return UtilList.append(bIons, yIons);
    }
}
