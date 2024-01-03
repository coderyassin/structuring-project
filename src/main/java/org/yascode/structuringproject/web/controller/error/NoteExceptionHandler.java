package org.yascode.structuringproject.web.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class NoteExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<ErrorResponse> handleNumberFormatException(NumberFormatException ex, WebRequest request) {
        logger.error("We have captured an exception "  + ex.getMessage());

        ErrorResponse.Builder errorResponseBuilder = ErrorResponse.builder(ex, HttpStatus.BAD_REQUEST, "The Input Data Is Invalid.");

        ErrorResponse errorResponse = errorResponseBuilder.type(URI.create("https://example.com/docs/errors/invalid-data"))
                .title("The Data Is Not Correct")
                .header("Content-Type", "application/json")
                .detailMessageCode("java.lang.NumberFormatException")
                .titleMessageCode("java.lang.NumberFormatException")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
