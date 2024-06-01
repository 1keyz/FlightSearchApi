package com.example.flightsearchapi.dtos.converters;


import com.example.flightsearchapi.model.entities.Airport;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.openapitools.model.AirportResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AirportDtoConverter implements Converter<Airport, AirportResponseDto> {

    @Override
    public AirportResponseDto convert(MappingContext<Airport, AirportResponseDto> mappingContext) {
        return convert(mappingContext.getSource());
    }

    public AirportResponseDto convert(Airport airport) {
        AirportResponseDto dto = new AirportResponseDto();
        dto.city(airport.getCity());
        return dto;
    }
}
