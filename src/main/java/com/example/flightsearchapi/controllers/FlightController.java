package com.example.flightsearchapi.controllers;

import com.example.flightsearchapi.dtos.requests.FlightRequestDto;
import com.example.flightsearchapi.dtos.requests.FlightySearchRequestDto;
import com.example.flightsearchapi.dtos.responses.FlightResponseDto;
import com.example.flightsearchapi.dtos.responses.FlightSearchResponseDto;
import com.example.flightsearchapi.services.abstracts.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
@AllArgsConstructor
public class FlightController {
    private FlightService flightService;

    @PostMapping("/add-flight")
    public FlightResponseDto addFlight(@RequestBody FlightRequestDto requestDto) {
        return flightService.addFlight(requestDto);
    }

    @PutMapping("/update/{id}")
    public FlightResponseDto updateFlight(@RequestBody FlightRequestDto requestDto,@PathVariable long id) {
        return flightService.updateFlight(requestDto,id);
    }


    @GetMapping("/get-all")
    public List<FlightResponseDto> getAllFlight() {
       return flightService.getAllFlight();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(long id) {
        flightService.deleteFlight(id);
    }


    @GetMapping("/flight-search")
    public FlightSearchResponseDto getFlightSearch(@RequestBody FlightySearchRequestDto requestDto) {
        return flightService.getFlightSearch(requestDto);
    }
}
