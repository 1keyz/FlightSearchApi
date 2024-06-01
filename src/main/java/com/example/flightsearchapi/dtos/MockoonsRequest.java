package com.example.flightsearchapi.dtos;


import lombok.Data;
import org.openapitools.model.FlightRequestDto;

import java.util.List;

@Data
public class MockoonsRequest {
    private List<FlightRequestDto> flights;
}
