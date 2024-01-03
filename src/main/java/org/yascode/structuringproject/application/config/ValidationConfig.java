package org.yascode.structuringproject.application.config;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public final class ValidationConfig {

    /**
     * Validator instance used to validate constraints.
     */
    private static final Validator VALIDATOR;

    private ValidationConfig() {
        throw new AssertionError("Utility class - do not instantiate");
    }

    static {
        ValidatorFactory validatorFactory =
                Validation.buildDefaultValidatorFactory();
        VALIDATOR = validatorFactory.getValidator();
    }

    /**
     * Gets the validator instance.
     *
     * @return validator instance.
     */
    public static Validator getValidator() {
        return VALIDATOR;
    }
}
