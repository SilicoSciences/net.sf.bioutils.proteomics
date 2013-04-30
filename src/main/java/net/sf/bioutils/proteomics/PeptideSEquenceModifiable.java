package net.sf.bioutils.proteomics;

public interface PeptideSEquenceModifiable extends PeptideSequence {

    void append(Peptide peptide);

    void insert(Peptide peptide, int index);

}
