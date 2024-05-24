package com.example.flightsearchapi.dtos.converters;

import com.example.flightsearchapi.dtos.responses.UserResponseDto;
import com.example.flightsearchapi.model.entities.User;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDtoConverter implements Converter<User, UserResponseDto> {
    @Override
    public UserResponseDto convert(MappingContext<User, UserResponseDto> mappingContext) {
        return convert(mappingContext.getSource());
    }

    public UserResponseDto convert(User user) {
        UserResponseDto dto = UserResponseDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        return dto;
    }
}
