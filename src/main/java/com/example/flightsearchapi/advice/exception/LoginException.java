package com.example.flightsearchapi.advice.exception;

public class LoginException extends RuntimeException{
    public LoginException(String message) {
        super(message);
    }
}