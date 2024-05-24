package com.example.flightsearchapi.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.http.HttpStatus;

public enum ErrorStatus {
    GENERAL("HY001", HttpStatus.BAD_REQUEST),
    USER_BLOCKED("HY002",HttpStatus.UNAUTHORIZED),
    NOT_FOUND("HY003", HttpStatus.NOT_FOUND),
    VALIDATION_ERROR("HY004",HttpStatus.BAD_GATEWAY),
    LOGIN_ERROR("HY005" , HttpStatus.BAD_REQUEST),
    AUTHENTICATION_ERROR("HY006",HttpStatus.UNAUTHORIZED),
    ACCES_DENIED_ERROR("HY007",HttpStatus.FORBIDDEN);

    private String errorValue;
    private HttpStatus status;

    ErrorStatus(String errorValue, HttpStatus status) {
        this.errorValue = errorValue;
        this.status = status;
    }

    @JsonValue
    public String getErrorValue() {
        return errorValue;
    }
    @JsonCreator
    public static ErrorStatus fromValue(String value) {
        for (ErrorStatus error : ErrorStatus.values()) {
            if (error.errorValue == value) {
                return error;
            }
        }
        throw new IllegalArgumentException("Invalid error value: " + value);
    }
}
