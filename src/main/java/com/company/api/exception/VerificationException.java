package com.company.api.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class VerificationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 6L;
    private final ErrorObject errorObject;
    public VerificationException(String message, ErrorObject errorObject) {
        super(message);
        this.errorObject = errorObject;
    }
}
