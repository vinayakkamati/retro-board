package com.retroboard.enums;

public enum ErrorReason {
    NOT_FOUND(1, "Unable to find requested resource"),
    BAD_REQUEST(2, "Bad request received");

    private final Integer id;
    private final String value;

    ErrorReason(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}