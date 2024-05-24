package com.example.flightsearchapi.dtos.requests;

import lombok.Data;

import java.util.List;

@Data
public class MockoonRequest {
    private List<FlightRequestDto> flights;
}
