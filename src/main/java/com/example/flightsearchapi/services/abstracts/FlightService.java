package com.example.flightsearchapi.services.abstracts;

import com.example.flightsearchapi.dtos.requests.FlightRequestDto;
import com.example.flightsearchapi.dtos.requests.FlightySearchRequestDto;
import com.example.flightsearchapi.dtos.responses.FlightResponseDto;
import com.example.flightsearchapi.dtos.responses.FlightSearchResponseDto;
import com.example.flightsearchapi.model.entities.Flight;

import java.util.List;

public interface FlightService {
    void deleteFlight(long id);
    FlightResponseDto addFlight(FlightRequestDto requestDto);
    FlightResponseDto updateFlight(FlightRequestDto requestDto , long id);
    List<FlightResponseDto> getAllFlight();
    Flight buyFlightByFlightCode(int flightCode);
    FlightSearchResponseDto getFlightSearch(FlightySearchRequestDto flightySearchRequestDto);
    void createAllFlight(List<FlightRequestDto> requestDtoList);
}
