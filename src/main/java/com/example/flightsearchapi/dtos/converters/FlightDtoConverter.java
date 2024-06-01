package com.example.flightsearchapi.dtos.converters;


import com.example.flightsearchapi.model.entities.Flight;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.openapitools.model.FlightResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
@AllArgsConstructor
public class FlightDtoConverter implements Converter<Flight, FlightResponseDto> {
    private AirportDtoConverter converter;
    @Override
    public FlightResponseDto convert(MappingContext<Flight, FlightResponseDto> mappingContext) {
        return convert(mappingContext.getSource());
    }

    public FlightResponseDto convert(Flight flight) {
        FlightResponseDto responseDto = new FlightResponseDto();
        responseDto.setDepartureAirport(converter.convert(flight.getDepartureAirport()));
        responseDto.setArrivalAirport(converter.convert(flight.getArrivalAirport()));
        responseDto.setDepartureAt(flight.getDepartureDateTime().atOffset(ZoneOffset.ofHours(0)));
        responseDto.arrivalAt(flight.getArrivalDateTime().atOffset(ZoneOffset.ofHours(0)));
        responseDto.price(flight.getPrice());
        responseDto.flightCode(flight.getFlightCode());
        return responseDto;
    }
}
