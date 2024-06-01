package com.example.flightsearchapi.services.abstracts;

import com.example.flightsearchapi.model.entities.Flight;
import org.openapitools.model.FlightRequestDto;
import org.openapitools.model.FlightResponseDto;
import org.openapitools.model.FlightSearchRequestDto;
import org.openapitools.model.FlightSearchResponseDto;

import java.util.List;

public interface FlightService {
    void deleteFlight(long id);
    FlightResponseDto addFlight(FlightRequestDto requestDto);
    FlightResponseDto updateFlight(FlightRequestDto requestDto , long id);
    List<FlightResponseDto> getAllFlight();
    Flight buyFlightByFlightCode(int flightCode);
    FlightSearchResponseDto getFlightSearch(FlightSearchRequestDto flightSearchRequestDto);
    void createAllFlight(List<FlightRequestDto> requestDtoList);
}
