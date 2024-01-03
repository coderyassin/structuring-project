package org.yascode.structuringproject.application.util;

public final class ErrorMessages {

    /**
     * Error message indicating that the date must be earlier
     * than the current date.
     */
    public static final String PAST_DATE_ERROR = "The date must"
            + " be prior to the current date";
    /**
     * Error message indicating that the name must begin with
     * "cat" and must not exceed 12 characters.
     */
    public static final String NAME_PATTERN_ERROR = "The name"
            + " must begin with cat and must not exceed 12 characters";

    private ErrorMessages() {
        throw new AssertionError("Utility class - do not instantiate");
    }
}
