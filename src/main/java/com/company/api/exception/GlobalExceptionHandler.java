package com.company.api.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        // 409, Nothing to do
    }

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<ErrorObject> handleUserExceptions(UserException ex, WebRequest request){
        return new ResponseEntity<>(ex.getErrorObject(), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = VerificationException.class)
    public ResponseEntity<ErrorObject> handleVerificationExceptions(VerificationException ex, WebRequest request){
        return new ResponseEntity<>(ex.getErrorObject(), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorObject> handleVerificationExceptions(Exception ex, WebRequest request){
        ex.printStackTrace();
        return new ResponseEntity<>(
                new ErrorObject(500,
                "Exception happened, Try Again Later",
                LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
