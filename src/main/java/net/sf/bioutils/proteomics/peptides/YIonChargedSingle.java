package net.sf.bioutils.proteomics.peptides;

import java.util.List;

public class YIonChargedSingle extends PeptideSequenceChargedSingle {

    public YIonChargedSingle(final List<AminoAcid> peptides) {
        super(peptides);
    }

    public YIonChargedSingle(final String string) {
        super(string);
    }

    public YIonChargedSingle(final String name, final List<AminoAcid> peptides) {
        super(name, peptides);
    }

}
