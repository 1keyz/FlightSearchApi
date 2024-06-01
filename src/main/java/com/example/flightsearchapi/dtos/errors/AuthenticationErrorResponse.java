package com.example.flightsearchapi.dtos.errors;

import com.example.flightsearchapi.model.enums.ErrorStatus;
import org.springframework.http.HttpStatus;

public class AuthenticationErrorResponse extends ErrorResponse{
    public AuthenticationErrorResponse(HttpStatus httpStatus,String detail) {
        setHttpStatus(httpStatus);
        setTitle("Authentication Rule Violation");
        setDetail(detail);
        setErrorCode(httpStatus.value());
        setStatus(ErrorStatus.AUTHENTICATION_ERROR);
    }
}
