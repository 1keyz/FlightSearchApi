package com.example.flightsearchapi.dtos.responses;

import lombok.Data;

import java.util.List;

@Data
public class FlightSearchResponseDto {
    private List<FlightResponseDto> departureFlights;
    private List<FlightResponseDto> returnFlights;
}
