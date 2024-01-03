package org.yascode.structuringproject.web.controller.contract;

import jakarta.validation.Validator;

public interface Validatable <T, N> {
    T getValidatableT();

    N getValidatableN();
}