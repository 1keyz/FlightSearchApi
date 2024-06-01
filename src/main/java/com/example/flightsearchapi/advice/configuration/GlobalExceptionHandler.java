package com.example.flightsearchapi.advice.configuration;

import com.example.flightsearchapi.advice.exception.LoginException;
import com.example.flightsearchapi.advice.exception.NotFoundException;

import com.example.flightsearchapi.dtos.errors.AccesDeniedErrorResponse;
import com.example.flightsearchapi.dtos.errors.AuthenticationErrorResponse;
import com.example.flightsearchapi.dtos.errors.LoginErrorResponse;
import com.example.flightsearchapi.dtos.errors.NotFoundErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    public NotFoundErrorResponse notFoundException(RuntimeException ex){
        NotFoundErrorResponse response = new NotFoundErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
        return response;
    }

    @ExceptionHandler(LoginException.class)
    public LoginErrorResponse loginException(RuntimeException ex){
        LoginErrorResponse response = new LoginErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return response;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public AccesDeniedErrorResponse accesDeniedException(Exception ex){
        AccesDeniedErrorResponse response = new AccesDeniedErrorResponse(HttpStatus.BAD_GATEWAY,ex.getMessage());
        return response;
    }

    @ExceptionHandler(AuthenticationException.class)
    public AuthenticationErrorResponse authenticationException(AuthenticationException ex){
        AuthenticationErrorResponse response = new AuthenticationErrorResponse(HttpStatus.UNAUTHORIZED,ex.getMessage());
        return response;
    }


}
