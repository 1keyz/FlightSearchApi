package com.example.flightsearchapi.services.abstracts;

import com.example.flightsearchapi.dtos.requests.AirportRequestDto;
import com.example.flightsearchapi.dtos.responses.AirportResponseDto;
import com.example.flightsearchapi.model.entities.Airport;

import java.util.List;

public interface AirportService {
    void deleteAirport(long id);
    AirportResponseDto addAirport(AirportRequestDto requestDto);
    AirportResponseDto updateAirport(AirportRequestDto requestDto , long id);

    List<AirportResponseDto> getAllAirport();
    Airport findAirportById(long id);
}
