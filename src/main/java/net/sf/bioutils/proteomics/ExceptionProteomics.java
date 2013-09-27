package net.sf.bioutils.proteomics;

public class ExceptionProteomics extends Exception {

    private static final long serialVersionUID = -1594573737396329206L;

    public ExceptionProteomics() {

    }

    public ExceptionProteomics(final String message) {
        super(message);

    }

    public ExceptionProteomics(final String message, final Throwable cause) {
        super(message, cause);

    }

    public ExceptionProteomics(final Throwable cause) {
        super(cause);

    }

}
