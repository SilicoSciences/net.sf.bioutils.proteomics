package net.sf.bioutils.proteomics;

public interface PeptideSEquenceModifiable extends PeptideSequence {

    void append(AminoAcid peptide);

    void insert(AminoAcid peptide, int index);

}
