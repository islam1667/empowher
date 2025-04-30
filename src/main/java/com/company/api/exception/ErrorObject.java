package com.company.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private LocalDateTime timestamp;
}
