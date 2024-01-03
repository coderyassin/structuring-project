package org.yascode.structuringproject.web.controller.error;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.yascode.structuringproject.application.util.ValidationUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<?> notValid(ConstraintViolationException ex, WebRequest request) {

        Map<String, List<String>> errorsMessage = new HashMap<>();

        ex.getConstraintViolations().forEach(c -> {
            String keyPrefix = ValidationUtil.getKeyPrefix(c.getRootBeanClass());
            if(errorsMessage.containsKey(keyPrefix + "." + c.getPropertyPath().toString())) {
                errorsMessage.get(keyPrefix + "." + c.getPropertyPath()).add(c.getMessage());
            } else {
                errorsMessage.put(keyPrefix + "." + c.getPropertyPath().toString(), new ArrayList<>() {
                    {
                        add(c.getMessage());
                    }
                });
            }
        });

        return ResponseEntity.badRequest().body(new HashMap<>() {{put("errors", errorsMessage);}});
    }

}
