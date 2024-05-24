package com.example.flightsearchapi.controllers;

import com.example.flightsearchapi.dtos.requests.LoginRequestDto;
import com.example.flightsearchapi.dtos.requests.UserRequestDto;
import com.example.flightsearchapi.dtos.responses.LoginResponseDto;
import com.example.flightsearchapi.dtos.responses.UserResponseDto;
import com.example.flightsearchapi.services.abstracts.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto){
        return authService.register(requestDto);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto){
        return authService.login(requestDto);
    }

    @PostMapping("/buy-flight/{flightCode}")
    public UserResponseDto buyFlight(@PathVariable int flightCode){
        return authService.buyFlight(flightCode);
    }

}
