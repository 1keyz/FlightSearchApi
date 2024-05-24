package com.example.flightsearchapi.dtos.converters;

import com.example.flightsearchapi.dtos.responses.FlightResponseDto;
import com.example.flightsearchapi.model.entities.Flight;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlightDtoConverter implements Converter<Flight, FlightResponseDto> {
    private AirportDtoConverter converter;
    @Override
    public FlightResponseDto convert(MappingContext<Flight, FlightResponseDto> mappingContext) {
        return convert(mappingContext.getSource());
    }

    public FlightResponseDto convert(Flight flight) {
        FlightResponseDto responseDto = FlightResponseDto.builder()
                .departureAirport(converter.convert(flight.getDepartureAirport()))
                .arrivalAirport(converter.convert(flight.getArrivalAirport()))
                .departureAt(flight.getDepartureDateTime())
                .arrivalAt(flight.getArrivalDateTime())
                .price(flight.getPrice())
                .flightCode(flight.getFlightCode())
                .build();
        return responseDto;
    }
}
