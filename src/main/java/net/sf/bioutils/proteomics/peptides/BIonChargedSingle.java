package net.sf.bioutils.proteomics.peptides;

import java.util.List;

public class BIonChargedSingle extends PeptideSequenceChargedSingle {

    public BIonChargedSingle(final List<AminoAcid> peptides) {
        super(peptides);
    }

    public BIonChargedSingle(final String string) {
        super(string);
    }

    public BIonChargedSingle(final String name, final List<AminoAcid> peptides) {
        super(name, peptides);
    }

    @Override
    public synchronized double getMolWeightNTerminal() {
        return 0;
    }

}
