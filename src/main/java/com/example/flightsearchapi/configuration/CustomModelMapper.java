package com.example.flightsearchapi.configuration;

import com.example.flightsearchapi.dtos.converters.AirportDtoConverter;
import com.example.flightsearchapi.dtos.converters.FlightDtoConverter;
import com.example.flightsearchapi.dtos.converters.UserRequestDtoConverter;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CustomModelMapper {
    private AirportDtoConverter airportDtoConverter;
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new AirportDtoConverter());
        modelMapper.addConverter(new FlightDtoConverter(airportDtoConverter));
        modelMapper.addConverter(new UserRequestDtoConverter());
        return modelMapper;
    }
}
