package net.sf.bioutils.proteomics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import net.sf.bioutils.proteomics.AminoAcid;
import net.sf.bioutils.proteomics.Modification;
import net.sf.bioutils.proteomics.PeptideSEquenceModifiable;
import net.sf.kerner.utils.collections.list.impl.UtilList;
import net.sf.kerner.utils.impl.util.Util;

public class PeptideSequenceChargedSingle implements PeptideSEquenceModifiable {

    private final List<AminoAcid> peptides = new ArrayList<AminoAcid>();

    private Collection<Modification> mods = new HashSet<Modification>();

    private transient double cacheMolWeight = -1;

    private String name;

    public PeptideSequenceChargedSingle(final List<AminoAcid> peptides) {
        this.peptides.addAll(peptides);
    }

    public PeptideSequenceChargedSingle(final String string) {
        for (final char c : string.toCharArray()) {
            peptides.add(AminoAcid.parseSingleChar(c));
        }
    }

    public PeptideSequenceChargedSingle(final String name, final List<AminoAcid> peptides) {
        this.name = name;
        this.peptides.addAll(peptides);
    }

    @Override
    public synchronized void append(final AminoAcid peptide) {
        peptides.add(peptide);
    }

    @Override
    public synchronized List<Character> asCharacterList() {
        final List<Character> result = UtilList.newList();
        for (final AminoAcid p : peptides) {
            result.add(p.getSingleCharIdent());
        }
        return result;
    }

    @Override
    public synchronized List<AminoAcid> asList() {
        return Collections.unmodifiableList(peptides);
    }

    @Override
    public synchronized List<String> asStringList() {
        return UtilList.toStringList(asCharacterList());
    }

    private void calculateMolWeight() {
        double result = 0;
        for (final AminoAcid p : peptides) {
            if (p.equals(AminoAcid.C)) {
                final int i = 0;
            }
            result += getMolWeight(p);
        }
        cacheMolWeight = result + getMolWeightCTerminal() + getMolWeightNTerminal();
    }

    @Override
    public boolean contains(final AminoAcid p) {
        return asList().contains(p);
    }

    @Override
    public synchronized boolean equals(final Object obj) {
        return Util.equalsOnHashCode(this, obj);
    }

    @Override
    public synchronized int getChargeState() {
        return 1;
    }

    @Override
    public synchronized Collection<Modification> getModifications() {
        return Collections.unmodifiableCollection(mods);
    }

    @Override
    public synchronized double getMolWeight() {
        if (cacheMolWeight < 0) {
            calculateMolWeight();
        }
        return cacheMolWeight;
    }

    private double getMolWeight(final AminoAcid p) {
        for (final Modification m : mods) {
            if (m.getParent().equals(p)) {
                return m.getMolWeight();
            }
        }
        return p.getMolWeight();
    }

    @Override
    public synchronized double getMolWeightCTerminal() {

        return MOL_WEIGHT_OXYGEN;
    }

    @Override
    public synchronized double getMolWeightNTerminal() {

        return (2 * MOL_WEIGHT_HYDROGEN) + (getChargeState() * MOL_WEIGHT_HYDROGEN);
    }

    public synchronized String getName() {
        return name;
    }

    @Override
    public synchronized int hashCode() {
        return peptides.hashCode();
    }

    @Override
    public synchronized void insert(final AminoAcid peptide, final int index) {
        peptides.add(index, peptide);
    }

    @Override
    public synchronized Iterator<AminoAcid> iterator() {
        return asList().iterator();
    }

    @Override
    public synchronized void setModifications(final Collection<Modification> modifications) {
        mods = new HashSet<Modification>(modifications);
        cacheMolWeight = -1;
    }

    public synchronized void setName(final String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        final StringBuilder sb = new StringBuilder(getName() + ": ");
        for (final AminoAcid p : peptides) {
            sb.append(p);
        }
        sb.append(":");
        sb.append(String.format("%10.4f", getMolWeight()));
        return sb.toString();
    }

}
