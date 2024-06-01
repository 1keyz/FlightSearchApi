package com.example.flightsearchapi.dtos.requests;

import com.example.flightsearchapi.dtos.DepartureFlightRequestDto;
import lombok.Data;

@Data
public class FlightSearchRequestDto {
    private DepartureFlightRequestDto departureFlightRequestDto;
    private DepartureFlightRequestDto returnFlightRequestDto;
}
