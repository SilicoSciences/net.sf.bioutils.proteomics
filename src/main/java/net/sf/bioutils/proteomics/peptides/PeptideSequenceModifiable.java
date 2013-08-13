package net.sf.bioutils.proteomics.peptides;


public interface PeptideSequenceModifiable extends Peptide {

    void append(AminoAcid peptide);

    void insert(AminoAcid peptide, int index);

}
