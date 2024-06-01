package com.example.flightsearchapi.services.impls;

import com.example.flightsearchapi.advice.exception.NotFoundException;
import com.example.flightsearchapi.model.entities.Airport;
import com.example.flightsearchapi.repositories.AirportRepository;
import com.example.flightsearchapi.services.abstracts.AirportService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openapitools.model.AirportRequestDto;
import org.openapitools.model.AirportResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AirportServiceImpl implements AirportService {
    private AirportRepository airportRepository;
    private ModelMapper modelMapper;
    @Override
    public void deleteAirport(long id) {
        airportRepository.deleteById(id);
    }

    @Override
    public AirportResponseDto addAirport(AirportRequestDto requestDto) {
        Airport airport = Airport.builder()
                .city(requestDto.getCity())
                .build();
        return modelMapper.map(airportRepository.save(airport),AirportResponseDto.class);
    }

    @Override
    public AirportResponseDto updateAirport(AirportRequestDto requestDto , long id) {
        Airport airport = findAirportById(id);
        airport.setCity(requestDto.getCity());
        return modelMapper.map(airportRepository.save(airport),AirportResponseDto.class);
    }

    @Override
    public List<AirportResponseDto> getAllAirport() {
        List<AirportResponseDto> airportDtoList = airportRepository.findAll().stream().map(airport ->
                modelMapper.map(airport, AirportResponseDto.class))
                .collect(Collectors.toList());
        return airportDtoList;
    }

    public Airport findAirportById(long id){
        return airportRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Airport Not Found"));
    }
}
