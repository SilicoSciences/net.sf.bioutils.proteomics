package net.sf.bioutils.proteomics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import net.sf.bioutils.proteomics.Modification;
import net.sf.bioutils.proteomics.Peptide;
import net.sf.bioutils.proteomics.PeptideSEquenceModifiable;
import net.sf.kerner.utils.collections.list.impl.UtilList;
import net.sf.kerner.utils.impl.util.Util;

public class PeptideSequenceChargedSingle implements PeptideSEquenceModifiable {

    private final List<Peptide> peptides = new ArrayList<Peptide>();

    private Collection<Modification> mods = new HashSet<Modification>();

    private transient double cacheMolWeight = -1;

    public PeptideSequenceChargedSingle(final List<Peptide> peptides) {
        this.peptides.addAll(peptides);
    }

    public PeptideSequenceChargedSingle(final String string) {
        for (final char c : string.toCharArray()) {
            peptides.add(Peptide.parseSingleChar(c));
        }
    }

    public synchronized void append(final Peptide peptide) {
        peptides.add(peptide);
    }

    public synchronized List<Character> asCharacterList() {
        final List<Character> result = UtilList.newList();
        for (final Peptide p : peptides) {
            result.add(p.getSingleCharIdent());
        }
        return result;
    }

    public synchronized List<Peptide> asList() {
        return Collections.unmodifiableList(peptides);
    }

    public synchronized List<String> asStringList() {
        return UtilList.toStringList(asCharacterList());
    }

    private void calculateMolWeight() {
        double result = 0;
        for (final Peptide p : peptides) {
            if (p.equals(Peptide.C)) {
                final int i = 0;
            }
            result += getMolWeight(p);
        }
        cacheMolWeight = result + getMolWeightCTerminal() + getMolWeightNTerminal();
    }

    public boolean contains(final Peptide p) {
        return asList().contains(p);
    }

    @Override
    public synchronized boolean equals(final Object obj) {
        return Util.equalsOnHashCode(this, obj);
    }

    public synchronized int getChargeState() {
        return 1;
    }

    public synchronized Collection<Modification> getModifications() {
        return Collections.unmodifiableCollection(mods);
    }

    public synchronized double getMolWeight() {
        if (cacheMolWeight < 0) {
            calculateMolWeight();
        }
        return cacheMolWeight;
    }

    private double getMolWeight(final Peptide p) {
        for (final Modification m : mods) {
            if (m.getParent().equals(p)) {
                return m.getMolWeight();
            }
        }
        return p.getMolWeight();
    }

    public synchronized double getMolWeightCTerminal() {

        return MOL_WEIGHT_OXYGEN;
    }

    public synchronized double getMolWeightNTerminal() {

        return (2 * MOL_WEIGHT_HYDROGEN) + (getChargeState() * MOL_WEIGHT_HYDROGEN);
    }

    @Override
    public synchronized int hashCode() {
        return peptides.hashCode();
    }

    public synchronized void insert(final Peptide peptide, final int index) {
        peptides.add(index, peptide);
    }

    public synchronized Iterator<Peptide> iterator() {
        return asList().iterator();
    }

    public synchronized void setModifications(final Collection<Modification> modifications) {
        mods = new HashSet<Modification>(modifications);
        cacheMolWeight = -1;
    }

    @Override
    public synchronized String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Peptide p : peptides) {
            sb.append(p);
        }
        sb.append(":");
        sb.append(String.format("%10.4f", getMolWeight()));
        return sb.toString();
    }

}
