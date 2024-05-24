package com.example.flightsearchapi.dtos.responses;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private String name;
    private String surname;
    private String password;
    private String email;
}
