package com.example.flightsearchapi.controllers;

import com.example.flightsearchapi.services.abstracts.AuthService;
import org.openapitools.api.AuthApi;
import org.openapitools.api.AuthApiDelegate;
import org.openapitools.model.LoginRequestDto;
import org.openapitools.model.LoginResponseDto;
import org.openapitools.model.UserRequestDto;
import org.openapitools.model.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import java.util.Optional;


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-01T13:56:22.993147+02:00[Europe/Paris]")
@Controller
@RequestMapping("${openapi.swaggerFlightApi.base-path:}")

public class AuthController implements AuthApi {
    private final AuthApiDelegate delegate;


    public AuthController(@Autowired(required = false) AuthApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new AuthApiDelegate() {});
    }

    @Override
    public ResponseEntity<UserResponseDto> buyFlight(Long flightCode) {
        return delegate.buyFlight(flightCode);
    }

    @Override
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto) {
        return delegate.login(loginRequestDto);
    }

    @Override
    public ResponseEntity<UserResponseDto> register(UserRequestDto userRequestDto) {
        return delegate.register(userRequestDto);
    }

   /* @PostMapping("/register")
    public UserResponseDto registerx(@RequestBody UserRequestDto requestDto){
        return authService.register(requestDto);
    }

    @PostMapping("/login")
    public LoginResponseDto loginx(@RequestBody LoginRequestDto requestDto){
        return authService.login(requestDto);
    }

    @PostMapping("/buy-flight/{flightCode}")
    public UserResponseDto buyFlight(@PathVariable int flightCode){
        return authService.buyFlight(flightCode);
    }


    */


}
