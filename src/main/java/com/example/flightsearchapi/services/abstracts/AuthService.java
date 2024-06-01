package com.example.flightsearchapi.services.abstracts;


import org.openapitools.model.LoginRequestDto;
import org.openapitools.model.LoginResponseDto;
import org.openapitools.model.UserRequestDto;
import org.openapitools.model.UserResponseDto;

import java.util.Optional;

public interface AuthService {

    UserResponseDto register(UserRequestDto requestDto);

    LoginResponseDto login(LoginRequestDto requestDto);
    UserResponseDto buyFlight(int flightCode);

}
