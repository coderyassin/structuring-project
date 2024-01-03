package org.yascode.structuringproject.application.validator;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.yascode.structuringproject.application.validation.NamePattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.yascode.structuringproject.application.util.ValidationConstants.CAT_PATTERN;

/**
 * Custom validator for the {@link NamePattern} annotation.
 * Validates that a given string adheres to a specific pattern.
 */
public class NamePatternValidator implements ConstraintValidator<NamePattern, String> {

    /**
     * Initializes the validator. This method is empty as there's no specific initialization logic.
     *
     * @param constraintAnnotation The annotation instance for this validator.
     */
    @Override
    public void initialize(final NamePattern constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Validates whether the provided string adheres to the specified pattern.
     *
     * @param s                         The string to be validated.
     * @param constraintValidatorContext The validation context.
     * @return true if the string is valid, false otherwise.
     */
    @Override
    public boolean isValid(final String s, final ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return false;
        }

        Pattern regex = Pattern.compile(CAT_PATTERN);

        Matcher matcher = regex.matcher(s);

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }

}
