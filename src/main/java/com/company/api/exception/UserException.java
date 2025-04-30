package com.company.api.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class UserException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 10L;
    private final ErrorObject errorObject;
    public UserException(String message, ErrorObject errorObject) {
        super(message);
        this.errorObject = errorObject;
    }
}
