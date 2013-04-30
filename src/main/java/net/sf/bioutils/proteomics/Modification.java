package net.sf.bioutils.proteomics;

public enum Modification {

    CARBAMIDOMETHYL(Peptide.C, 160.030654);

    private final Peptide parent;

    private final double molWeight;

    private Modification(final Peptide parent, final double molWeight) {
        this.molWeight = molWeight;
        this.parent = parent;
    }

    public double getMolWeight() {
        return molWeight;
    }

    public Peptide getParent() {
        return parent;
    }

}
