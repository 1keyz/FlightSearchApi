package com.example.flightsearchapi.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private String password;
    private String email;
    private String token;
}
