package com.example.flightsearchapi.dtos.errors;

import com.example.flightsearchapi.model.enums.ErrorStatus;
import org.springframework.http.HttpStatus;

public class AccesDeniedErrorResponse extends ErrorResponse{
    public AccesDeniedErrorResponse(HttpStatus httpStatus,String detail) {
        setHttpStatus(httpStatus);
        setTitle("AccesDenied Rule Violation");
        setDetail(detail);
        setErrorCode(httpStatus.value());
        setStatus(ErrorStatus.ACCES_DENIED_ERROR);
    }
}
