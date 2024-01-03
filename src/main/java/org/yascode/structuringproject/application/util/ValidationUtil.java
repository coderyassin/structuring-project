package org.yascode.structuringproject.application.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.yascode.structuringproject.application.config.ValidationConfig;
import org.yascode.structuringproject.web.controller.contract.Validatable;

import java.util.HashSet;
import java.util.Set;

import static org.yascode.structuringproject.application.util.ValidationConstants.DTO;

public final class ValidationUtil {

    private ValidationUtil() {
        throw new AssertionError("Utility class - do not instantiate");
    }

    /**
     * Gets the key prefix based on the provided root bean class.
     *
     * @param rootBeanClass The root bean class for which to get the key prefix.
     * @return The key prefix.
     */
    public static String getKeyPrefix(final Class<?> rootBeanClass) {
        String keyPrefix = rootBeanClass.getSimpleName().replace(DTO, "");
        keyPrefix = Character.toLowerCase(keyPrefix.charAt(0))
                    + keyPrefix.substring(1);
        return keyPrefix;
    }

    /**
     * Validates a {@link Validatable} request object using the validator
     * configured in {@link ValidationConfig}.
     *
     * @param request The request object to validate.
     * @param <T>     The type of the first part of the request object.
     * @param <N>     The type of the second part of the request object.
     * @return True if validation succeeds.
     * @throws ConstraintViolationException If constraint violations
     * are detected during validation.
     */
    public static <T, N> boolean validateRequest(final Validatable<T, N> request) {
        Set<ConstraintViolation<T>> validateT = ValidationConfig.getValidator().validate(request.getValidatableT());

        Set<ConstraintViolation<N>> validateN = ValidationConfig.getValidator().validate(request.getValidatableN());

        Set<ConstraintViolation<?>> validate = combineViolations(validateT, validateN);

        if (!validate.isEmpty()) {
            throw new ConstraintViolationException(validate);
        }

        return true;
    }

    private static <T, N> Set<ConstraintViolation<?>> combineViolations(
            final Set<ConstraintViolation<T>> set1, final Set<ConstraintViolation<N>> set2) {
        Set<ConstraintViolation<?>> combinedSet = new HashSet<>();
        combinedSet.addAll(set1);
        combinedSet.addAll(set2);
        return combinedSet;
    }

}
