package com.example.flightsearchapi.services.abstracts;

import com.example.flightsearchapi.model.entities.Airport;
import org.openapitools.model.AirportRequestDto;
import org.openapitools.model.AirportResponseDto;

import java.util.List;

public interface AirportService {
    void deleteAirport(long id);
    AirportResponseDto addAirport(AirportRequestDto requestDto);
    AirportResponseDto updateAirport(AirportRequestDto requestDto , long id);

    List<AirportResponseDto> getAllAirport();
    Airport findAirportById(long id);
}
