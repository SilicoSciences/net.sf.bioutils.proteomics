package net.sf.bioutils.proteomics.peptidesearcher;

import java.util.Collection;
import java.util.List;

import net.sf.jfasta.impl.HeaderDialectUniprot;
import net.sf.kerner.utils.collections.UtilCollection;

class FactoryResult {

    static boolean areSameByID(final Collection<String> headers, final DatabaseID databaseID) {
        boolean result = true;
        String idOld = null;
        for (final String header : headers) {
            final String id = getIDStringFromHeader(header, databaseID);
            if (idOld == null || idOld.equals(id)) {
                idOld = id;
            } else if (idOld != null && !idOld.equals(id)) {
                result = false;
                break;
            }
        }
        return result;
    }

    static String getIDStringFromHeader(final String fastaHeader, final DatabaseID databaseId) {
        final HeaderDialectUniprot headerDialect = new HeaderDialectUniprot();
        headerDialect.setHeaderString(fastaHeader);
        switch (databaseId) {
            case ACCESSION:
                return headerDialect.getAccessionNumber();
            case GENE:
                return headerDialect.getGeneName();
            case PROTEIN:
                return headerDialect.getProteinName();
            case SPECIES:
                return headerDialect.getSpeciesName();
            default:
                throw new RuntimeException("Unkown ID " + databaseId);
        }
    }

    public Result create(final List<String> headers, final DatabaseID type) {

        if (UtilCollection.nullOrEmpty(headers)) {
            return new Result();
        }

        if (headers.size() == 1) {
            return Result.buildProteotypic(headers);

        } else {

            if (type.equals(DatabaseID.PROTEIN_GENE)
                    && (areSameByID(headers, DatabaseID.SPECIES) && (areSameByID(headers,
                            DatabaseID.PROTEIN) || areSameByID(headers, DatabaseID.GENE)))) {
                return Result.buildProteotypic(headers);
            }

            return Result.buildDegen(headers);
        }
    }
}
