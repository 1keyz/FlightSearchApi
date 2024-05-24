package com.example.flightsearchapi.dtos.requests;

import com.example.flightsearchapi.model.enums.RoleEnum;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequestDto {
    private String name;
    private String surname;
    private String password;
    private String email;
    private Set<RoleEnum> roleEnum;
}
