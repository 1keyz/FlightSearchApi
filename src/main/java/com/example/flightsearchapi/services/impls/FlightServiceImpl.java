package com.example.flightsearchapi.services.impls;

import com.example.flightsearchapi.advice.exception.NotFoundException;
import com.example.flightsearchapi.model.entities.Airport;
import com.example.flightsearchapi.model.entities.Flight;
import com.example.flightsearchapi.repositories.FlightRepository;
import com.example.flightsearchapi.services.abstracts.AirportService;
import com.example.flightsearchapi.services.abstracts.FlightService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openapitools.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;
    private ModelMapper modelMapper;
    private AirportService airportService;

    @Override
    public void deleteFlight(long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public FlightResponseDto addFlight(FlightRequestDto requestDto) {
        Flight flight = Flight.builder()
                .departureAirport(airportService.findAirportById(requestDto.getDepartureAirportId()))
                .arrivalAirport(airportService.findAirportById(requestDto.getArrivalAirportId()))
                .departureDateTime(requestDto.getDepartureAt().toLocalDateTime())
                .arrivalDateTime(requestDto.getArrivalAt().toLocalDateTime())
                .price(requestDto.getPrice())
                .build();

        return modelMapper.map(flightRepository.save(flight),FlightResponseDto.class);
    }

    @Override
    public FlightResponseDto updateFlight(FlightRequestDto requestDto, long id) {
        Flight flight = findFlightById(id);
        flight.setPrice(requestDto.getPrice());
        flight.setArrivalDateTime(requestDto.getArrivalAt().toLocalDateTime());
        flight.setDepartureDateTime(requestDto.getDepartureAt().toLocalDateTime());
        flight.setDepartureAirport(airportService.findAirportById(requestDto.getDepartureAirportId()));
        flight.setArrivalAirport(airportService.findAirportById(requestDto.getArrivalAirportId()));

        return modelMapper.map(flightRepository.save(flight),FlightResponseDto.class);
    }

    @Override
    public List<FlightResponseDto> getAllFlight() {
        List<FlightResponseDto> flightResponseDtoList = flightRepository.findAll().stream().map(fligt
                -> modelMapper.map(fligt,FlightResponseDto.class))
                .collect(Collectors.toList());

        return flightResponseDtoList;
    }

    private Flight findFlightById(long id){
        return flightRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Flight Not Found!"));
    }

    public Flight buyFlightByFlightCode(int flightCode) {
        return flightRepository.getFlightByFlightCode(flightCode);
    }


    @Override
    public FlightSearchResponseDto getFlightSearch(FlightSearchRequestDto requestDto) {
        Airport departureAirport = airportService.findAirportById(requestDto.getDepartureAirportCode());
        Airport destinationAirport = airportService.findAirportById(requestDto.getDestinationAirportCode());

        LocalDateTime departureAt = requestDto.getDepartAt().atStartOfDay();
        LocalDateTime departEnd = requestDto.getDepartAt().atTime(LocalTime.MAX);

        List<Flight> departureFlights = flightRepository.searchFlight(
                departureAirport.getId(),
                destinationAirport.getId(),
                departureAt,
                departEnd);

        List<Flight> returnFlightList = null;
        if(requestDto.getReturnOn() != null){
            LocalDateTime returnStart = requestDto.getReturnOn().atStartOfDay();
            LocalDateTime returnEnd = requestDto.getReturnOn().atTime(LocalTime.MAX);

            returnFlightList = flightRepository.searchFlight(
                    destinationAirport.getId(),
                    departureAirport.getId(),
                    returnStart,
                    returnEnd);
        }

        FlightSearchResponseDto responseDto = new FlightSearchResponseDto();
        responseDto.departureFlights(departureFlights.stream().map( dto
                -> modelMapper.map(dto,FlightResponseDto.class)).collect(Collectors.toList()));

        responseDto.returnFlights( returnFlightList.stream().map(
                dto -> modelMapper.map(dto,FlightResponseDto.class)).collect(Collectors.toList()));

        return responseDto;
    }

    @Override
    public void createAllFlight(List<FlightRequestDto> requestDtoList) {
        List<Flight> flightList = new ArrayList<>();
        for (FlightRequestDto req : requestDtoList){
            Flight flight = Flight.builder()
                    .flightCode(req.getFlightCode())
                    .price(req.getPrice())
                    .arrivalAirport(airportService.findAirportById(req.getArrivalAirportId()))
                    .departureAirport(airportService.findAirportById(req.getDepartureAirportId()))
                    .arrivalDateTime(req.getArrivalAt().toLocalDateTime())
                    .departureDateTime(req.getDepartureAt().toLocalDateTime())
                    .build();
            flightList.add(flight);
        }
        flightRepository.saveAll(flightList);
    }

}
