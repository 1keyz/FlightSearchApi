package com.example.flightsearchapi.dtos.responses.errors;

import com.example.flightsearchapi.model.enums.ErrorStatus;
import org.springframework.http.HttpStatus;

public class LoginErrorResponse extends ErrorResponse{
    public LoginErrorResponse(HttpStatus httpStatus, String detail) {
        setHttpStatus(httpStatus);
        setTitle("Login Rule Violation");
        setDetail(detail);
        setErrorCode(httpStatus.value());
        setStatus(ErrorStatus.LOGIN_ERROR);
    }
}
