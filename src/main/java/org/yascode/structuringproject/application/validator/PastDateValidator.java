package org.yascode.structuringproject.application.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.yascode.structuringproject.application.validation.PastDate;

import java.time.LocalDateTime;

/**
 * Custom validator for the {@link PastDate} annotation.
 * Validates that a given {@link LocalDateTime} is in the past.
 */
public class PastDateValidator implements ConstraintValidator<PastDate, LocalDateTime> {

    /**
     * Initializes the validator. This method is empty as there's no specific initialization logic.
     *
     * @param constraintAnnotation The annotation instance for this validator.
     */
    @Override
    public void initialize(final PastDate constraintAnnotation) {
        // No specific initialization logic for this validator.
    }

    /**
     * Validates whether the provided {@link LocalDateTime} is in the past.
     *
     * @param localDateTime             The {@link LocalDateTime} to be validated.
     * @param constraintValidatorContext The validation context.
     * @return true if the date is in the past, false otherwise.
     */
    @Override
    public boolean isValid(final LocalDateTime localDateTime,
                           final ConstraintValidatorContext constraintValidatorContext) {
        if (localDateTime == null) {
            // Null values are considered valid.
            return true;
        }

        LocalDateTime currentDate = LocalDateTime.now();
        return localDateTime.isBefore(currentDate);
    }
}
