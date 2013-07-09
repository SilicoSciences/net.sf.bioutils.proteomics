package net.sf.bioutils.proteomics;

public interface PeptideSEquenceModifiable extends Peptide {

    void append(AminoAcid peptide);

    void insert(AminoAcid peptide, int index);

}
