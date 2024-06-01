package com.example.flightsearchapi.controllers;


import com.example.flightsearchapi.services.abstracts.AirportService;
import lombok.AllArgsConstructor;
import org.openapitools.api.AirportApi;
import org.openapitools.api.AirportApiDelegate;
import org.openapitools.model.AirportRequestDto;
import org.openapitools.model.AirportResponseDto;
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
public class AirportController implements AirportApi {

    private final AirportApiDelegate delegate;

    public AirportController( @org.springframework.beans.factory.annotation.Autowired(required = false) AirportApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public ResponseEntity<AirportResponseDto> addAirport(AirportRequestDto airportRequestDto) {
        return delegate.addAirport(airportRequestDto);
    }

    @Override
    public ResponseEntity<Void> deleteAirport(Long id) {
        return delegate.deleteAirport(id);
    }

    @Override
    public ResponseEntity<AirportResponseDto> getAllAirport() {
        return delegate.getAllAirport();
    }

    @Override
    public ResponseEntity<AirportResponseDto> updateAirport(Long id) {
        return delegate.updateAirport(id);
    }

    /*  @PostMapping("/add-airport")
    public AirportResponseDto addAirport(@RequestBody AirportRequestDto requestDto) {
        return service.addAirport(requestDto);
    }

    @PutMapping("{id}")
    public AirportResponseDto updateAirport(@RequestBody AirportRequestDto requestDto ,@PathVariable long id) {
        return service.updateAirport(requestDto,id);
    }

    @GetMapping("/get-all")
    public List<AirportResponseDto> getAllAirport() {
        return service.getAllAirport();
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable long id){
        service.deleteAirport(id);
    }

   */
}
