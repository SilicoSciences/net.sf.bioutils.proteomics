package net.sf.bioutils.proteomics;

public enum Peptide {

    A("Ala", 71.0788), C("Cys", 103.1448), D("Asp", 115.0886), E("Glu", 129.1155), F("Phe", 147.1766), G("Gly", 57.052), H(
            "His", 137.1412), I("Ile", 113.1595), K("Lys", 128.1742), L("Leu", 113.1595), M("Met", 131.1986), N("Asn",
            114.1039), P("Pro", 97.1167), Q("Gln", 128.1308), R("Arg", 156.1876), S("Ser", 87.0782), T("Thr", 101.1051), V(
            "Val", 99.1326), W("Trp", 186.2133), Y("Tyr", 163.1760);

    public static Peptide parse(final String s) {
        if (s.length() == 1 || s.length() == 3) {
            final String s2 = s.toUpperCase();
            if (s2.length() == 1) {
                return parseSingleChar(s2.charAt(0));
            } else if (s2.length() == 3) {
                return parseTrippleChar(s2);
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new IllegalArgumentException("invalid length " + s.length());
        }
    }

    private static Peptide parseSingleChar(final char c) {
        for (final Peptide p : values()) {
            if (p.getSingleCharIdent() == c) {
                return p;
            }
        }
        throw new IllegalArgumentException("unknown peptide " + c);
    }

    private static Peptide parseTrippleChar(final String s) {
        for (final Peptide p : values()) {
            if (p.getTrippeCharIdent().equals(s)) {
                return p;
            }
        }
        throw new IllegalArgumentException("unknown peptide " + s);
    }

    private final double molWeight;

    private final String trippleCharIdent;

    private Peptide(final String trippleCharIdent, final double molWeight) {
        this.molWeight = molWeight;
        this.trippleCharIdent = trippleCharIdent;
    }

    public double getMolWeight() {
        return molWeight;
    }

    public char getSingleCharIdent() {
        return toString().charAt(0);
    }

    public String getTrippeCharIdent() {
        return trippleCharIdent;
    }

}
