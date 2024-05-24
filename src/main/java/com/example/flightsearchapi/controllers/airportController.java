package com.example.flightsearchapi.controllers;


import com.example.flightsearchapi.dtos.requests.AirportRequestDto;
import com.example.flightsearchapi.dtos.responses.AirportResponseDto;
import com.example.flightsearchapi.model.entities.Airport;
import com.example.flightsearchapi.services.abstracts.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
@AllArgsConstructor
public class airportController {
    private AirportService service;

    @PostMapping
    public AirportResponseDto addAirport(@RequestBody AirportRequestDto requestDto) {
        return service.addAirport(requestDto);
    }

    @PutMapping("/{id}")
    public AirportResponseDto updateAirport(@RequestBody AirportRequestDto requestDto ,@PathVariable long id) {
        return service.updateAirport(requestDto,id);
    }

    @GetMapping("/get-all")
    public List<AirportResponseDto> getAllAirport() {
        return service.getAllAirport();
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(long id){
        service.deleteAirport(id);
    }
}
