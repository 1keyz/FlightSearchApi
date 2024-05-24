package com.example.flightsearchapi.services.abstracts;

import com.example.flightsearchapi.dtos.requests.LoginRequestDto;
import com.example.flightsearchapi.dtos.requests.UserRequestDto;
import com.example.flightsearchapi.dtos.responses.LoginResponseDto;
import com.example.flightsearchapi.dtos.responses.UserResponseDto;
import com.example.flightsearchapi.model.entities.User;

import java.util.Optional;

public interface AuthService {

    UserResponseDto register(UserRequestDto requestDto);

    LoginResponseDto login(LoginRequestDto requestDto);
    UserResponseDto buyFlight(int flightCode);

}
