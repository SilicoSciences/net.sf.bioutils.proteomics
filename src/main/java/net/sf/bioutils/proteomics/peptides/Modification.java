package net.sf.bioutils.proteomics.peptides;

public enum Modification {

    CARBAMIDOMETHYL(AminoAcid.C, 160.030654);

    private final AminoAcid parent;

    private final double molWeight;

    private Modification(final AminoAcid parent, final double molWeight) {
        this.molWeight = molWeight;
        this.parent = parent;
    }

    public double getMolWeight() {
        return molWeight;
    }

    public AminoAcid getParent() {
        return parent;
    }

}
