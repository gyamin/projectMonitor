package com.gyamin.pjmonitor.web.exception;

import org.springframework.validation.FieldError;

import java.util.List;

public class ValidateException extends ApplicationException{
    public ValidateException(String message) {
        super(message);
    }
    public List<FieldError> errors;
}
