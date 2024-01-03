package org.yascode.structuringproject.application.util;

public final class ValidationConstants {

    /**
     * Constant representing the "DTO" string.
     */
    public static final String DTO = "DTO";
    /**
     * Template for name validation, with the constraint that the name must
     * begin with "cat" and must not exceed 9 additional characters.
     */
    public static final String CAT_PATTERN = "^(?i)cat.{0,9}$";

    private ValidationConstants() {
        throw new AssertionError("Utility class - do not instantiate");
    }

}
