package com.retroboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends GenericException {
    public BadRequestException(ErrorMessage message) {
        super(message);
    }
}
