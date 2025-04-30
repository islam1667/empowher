package com.company.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.time.LocalDateTime;

@ResponseStatus(value= HttpStatus.FORBIDDEN)
public class VerificationTokenExpiredException extends VerificationException {
    @Serial
    private static final long serialVersionUID = 2L;
    public VerificationTokenExpiredException(String message) {
        super(message,
                new ErrorObject(HttpStatus.FORBIDDEN.value(),
                        "Verification Token Expired",
                        LocalDateTime.now()));
    }
}
