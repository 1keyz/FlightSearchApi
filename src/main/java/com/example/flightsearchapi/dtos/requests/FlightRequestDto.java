package com.example.flightsearchapi.dtos.requests;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightRequestDto {
    private int flightCode;
    private long departureAirportId;
    private long arrivalAirportId;
    private LocalDateTime departureAt;
    private LocalDateTime arrivalAt;
    private double price;
}
