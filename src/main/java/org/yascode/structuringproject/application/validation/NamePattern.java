package org.yascode.structuringproject.application.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.yascode.structuringproject.application.validator.NamePatternValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.yascode.structuringproject.application.util.ErrorMessages.NAME_PATTERN_ERROR;

/**
 * Custom annotation for validating name patterns.
 * Uses the {@link NamePatternValidator} for validation.
 */
@Documented
@Constraint(validatedBy = NamePatternValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NamePattern {
    /**
     * Default error message in case of name pattern violation.
     *
     * @return The default error message.
     */
    String message() default NAME_PATTERN_ERROR;

    /**
     * Validation groups. Not used in this example.
     *
     * @return The validation groups.
     */
    Class<?>[] groups() default {};

    /**
     * Payload for validation integration.
     *
     * @return The payload for validation integration.
     */
    Class<? extends Payload>[] payload() default {};

}
