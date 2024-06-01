package com.example.flightsearchapi.dtos.errors;

import com.example.flightsearchapi.model.enums.ErrorStatus;
import org.springframework.http.HttpStatus;

public class NotFoundErrorResponse extends ErrorResponse{
    public NotFoundErrorResponse(HttpStatus httpStatus, String detail) {
        setHttpStatus(httpStatus);
        setTitle("NotFound Rule Violation");
        setDetail(detail);
        setErrorCode(httpStatus.value());
        setStatus(ErrorStatus.NOT_FOUND);
    }
}
