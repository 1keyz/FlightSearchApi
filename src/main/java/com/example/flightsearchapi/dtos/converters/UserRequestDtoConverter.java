package com.example.flightsearchapi.dtos.converters;


import com.example.flightsearchapi.model.entities.User;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.openapitools.model.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDtoConverter implements Converter<User, UserResponseDto> {
    @Override
    public UserResponseDto convert(MappingContext<User, UserResponseDto> mappingContext) {
        return convert(mappingContext.getSource());
    }

    public UserResponseDto convert(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setName(user.getName());
        dto.surname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        return dto;
    }
}
