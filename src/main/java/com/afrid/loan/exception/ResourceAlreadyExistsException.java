package com.afrid.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
