package com.example.flightsearchapi.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirportResponseDto {
    private String city;
}
