package net.sf.bioutils.proteomics;

import java.util.Collection;
import java.util.List;

public interface Peptide extends Iterable<AminoAcid> {

    public static double MOL_WEIGHT_OXYGEN = 15.9994;

    public static double MOL_WEIGHT_HYDROGEN = 1.0078;

    List<Character> asCharacterList();

    List<AminoAcid> asList();

    List<String> asStringList();

    boolean contains(AminoAcid p);

    int getChargeState();

    Collection<Modification> getModifications();

    double getMolWeight();

    double getMolWeightCTerminal();

    double getMolWeightNTerminal();

    void setModifications(Collection<Modification> modifications);

}
