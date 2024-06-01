package com.example.flightsearchapi.dtos.errors;

import com.example.flightsearchapi.model.enums.ErrorStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String title;
    private String detail;
    private int errorCode;
    private ErrorStatus status;
}
