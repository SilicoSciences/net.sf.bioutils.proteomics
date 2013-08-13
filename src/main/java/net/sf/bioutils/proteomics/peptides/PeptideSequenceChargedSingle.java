package net.sf.bioutils.proteomics.peptides;

import java.util.List;

public class PeptideSequenceChargedSingle extends PeptideSequenceAbstract implements PeptideSequenceModifiable {

    public PeptideSequenceChargedSingle(final List<AminoAcid> peptides) {
        super(peptides);
    }

    public PeptideSequenceChargedSingle(final String string) {
        super(string);
    }

    public PeptideSequenceChargedSingle(final String name, final List<AminoAcid> peptides) {
        super(name, peptides);
    }

    @Override
    public synchronized void append(final AminoAcid peptide) {
        peptides.add(peptide);
    }

    @Override
    public synchronized int getChargeState() {
        return 1;
    }

    @Override
    public synchronized void insert(final AminoAcid peptide, final int index) {
        peptides.add(index, peptide);
    }

}
