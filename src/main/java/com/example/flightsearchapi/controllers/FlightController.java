package com.example.flightsearchapi.controllers;

import com.example.flightsearchapi.services.abstracts.FlightService;
import lombok.AllArgsConstructor;
import org.openapitools.api.FlightApi;
import org.openapitools.api.FlightApiDelegate;
import org.openapitools.model.FlightRequestDto;
import org.openapitools.model.FlightResponseDto;
import org.openapitools.model.FlightSearchRequestDto;
import org.openapitools.model.FlightSearchResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-01T13:56:22.993147+02:00[Europe/Paris]")
@Controller
@RequestMapping("${openapi.swaggerFlightApi.base-path:}")
public class FlightController implements FlightApi {

    private final FlightApiDelegate delegate;

    public FlightController( @org.springframework.beans.factory.annotation.Autowired(required = false) FlightApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public ResponseEntity<FlightResponseDto> addFlight(FlightRequestDto flightRequestDto) {
        return delegate.addFlight(flightRequestDto);
    }

    @Override
    public ResponseEntity<Void> deleteFlight(Long id) {
        return delegate.deleteFlight(id);
    }

    @Override
    public ResponseEntity<FlightResponseDto> getAllFlight() {
        return delegate.getAllFlight();
    }

    @Override
    public ResponseEntity<FlightSearchResponseDto> getFlightSearch(FlightSearchRequestDto flightSearchRequestDto) {
        return delegate.getFlightSearch(flightSearchRequestDto);
    }

    @Override
    public ResponseEntity<FlightResponseDto> updateFlight(Long id, FlightRequestDto flightRequestDto) {
        return delegate.updateFlight( id,flightRequestDto);
    }

   /* @PostMapping("/add-flight")
    public FlightResponseDto addFlightx(@RequestBody FlightRequestDto requestDto) {
        return flightService.addFlight(requestDto);
    }

    @PutMapping("/{id}")
    public FlightResponseDto updateFlightx(@RequestBody FlightRequestDto requestDto,@PathVariable long id) {
        return flightService.updateFlight(requestDto,id);
    }


    @GetMapping("/get-all")
    public List<FlightResponseDto> getAllFlightx() {
       return flightService.getAllFlight();
    }

    @DeleteMapping("/{id}")
    public void deleteFlightx(@PathVariable long id) {
        flightService.deleteFlight(id);
    }


    @PostMapping("/flight-search")
    public FlightSearchResponseDto getFlightSearchx(@RequestBody FlightSearchRequestDto requestDto) {
        return flightService.getFlightSearch(requestDto);
    }


    */

}
