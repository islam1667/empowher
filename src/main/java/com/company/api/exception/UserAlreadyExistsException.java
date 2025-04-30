package com.company.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.time.LocalDateTime;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class UserAlreadyExistsException extends UserException {
  @Serial
  private static final long serialVersionUID = 4L;
    public UserAlreadyExistsException(String message) {
        super(message,
                new ErrorObject(HttpStatus.FORBIDDEN.value(),
                        "User Already Exist",
                        LocalDateTime.now()));
    }
}
