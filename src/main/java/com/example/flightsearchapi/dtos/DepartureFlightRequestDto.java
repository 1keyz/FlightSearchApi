package com.example.flightsearchapi.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DepartureFlightRequestDto {
    private Long departureAirportId;
    private Long arrivalAirportId;
    private LocalDate departureAt;
}
