package com.example.flightsearchapi.dtos.requests;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class FlightySearchRequestDto {
    private DepartureFlightRequestDto departureFlightRequestDto;
    private DepartureFlightRequestDto returnFlightRequestDto;
}
