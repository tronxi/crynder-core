package com.crynder.cryndercore.infrastructure.api.error;

import com.crynder.cryndercore.domain.exceptions.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DomainExceptionHandler {

    @ExceptionHandler(value = DomainException.class)
    public ResponseEntity<Error> exception(DomainException exception) {
        return new ResponseEntity<>(new Error(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
