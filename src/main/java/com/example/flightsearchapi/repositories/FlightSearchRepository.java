package com.example.flightsearchapi.repositories;

import com.example.flightsearchapi.dtos.requests.DepartureFlightRequestDto;
import com.example.flightsearchapi.model.entities.Flight;

import java.util.List;

public interface FlightSearchRepository {
    List<Flight> getFlight(DepartureFlightRequestDto requestDto);
}
