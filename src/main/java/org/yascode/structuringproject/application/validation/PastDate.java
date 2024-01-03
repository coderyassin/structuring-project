package org.yascode.structuringproject.application.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.yascode.structuringproject.application.validator.PastDateValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.yascode.structuringproject.application.util.ErrorMessages.PAST_DATE_ERROR;

/**
 * Custom annotation for validating that a date is in the past.
 * Uses the {@link PastDateValidator} for validation.
 */
@Documented
@Constraint(validatedBy = PastDateValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PastDate {

    /**
     * Default error message in case the date is not in the past.
     *
     * @return The default error message.
     */
    String message() default PAST_DATE_ERROR;

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
