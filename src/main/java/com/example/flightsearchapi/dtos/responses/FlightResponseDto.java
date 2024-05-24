package com.example.flightsearchapi.dtos.responses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FlightResponseDto {
    private AirportResponseDto departureAirport;
    private AirportResponseDto arrivalAirport;
    private LocalDateTime departureAt;
    private LocalDateTime arrivalAt;
    private double price;
    private int flightCode;
}
