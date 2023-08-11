package com.retroboard.exceptions;

import lombok.Data;

@Data
public abstract class GenericException extends RuntimeException {
    protected ErrorMessage errorMessage;

    public GenericException(ErrorMessage message) {
        super(message.getDeveloperMessage());
        this.errorMessage = message;
    }
}