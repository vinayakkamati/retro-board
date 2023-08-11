package com.retroboard.exceptions;

import com.retroboard.enums.ErrorReason;
import org.springframework.http.HttpStatus;

public class ErrorMessage {
    private HttpStatus httpStatus;
    private ErrorReason errorReason;
    private String developerMessage;

    public ErrorMessage(HttpStatus httpStatus, ErrorReason errorReason, String developerMessage) {
        this.httpStatus = httpStatus;
        this.errorReason = errorReason;
        this.developerMessage = developerMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ErrorReason getErrorMessage() {
        return errorReason;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }
}