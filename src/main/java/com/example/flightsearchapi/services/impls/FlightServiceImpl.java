package com.example.flightsearchapi.services.impls;

import com.example.flightsearchapi.advice.exception.NotFoundException;
import com.example.flightsearchapi.dtos.requests.DepartureFlightRequestDto;
import com.example.flightsearchapi.dtos.requests.FlightRequestDto;
import com.example.flightsearchapi.dtos.requests.FlightySearchRequestDto;
import com.example.flightsearchapi.dtos.responses.FlightResponseDto;
import com.example.flightsearchapi.dtos.responses.FlightSearchResponseDto;
import com.example.flightsearchapi.model.entities.Flight;
import com.example.flightsearchapi.model.entities.User;
import com.example.flightsearchapi.repositories.FlightRepository;
import com.example.flightsearchapi.repositories.FlightSearchRepository;
import com.example.flightsearchapi.services.abstracts.AirportService;
import com.example.flightsearchapi.services.abstracts.AuthService;
import com.example.flightsearchapi.services.abstracts.FlightService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;
    private ModelMapper modelMapper;
    private AirportService airportService;
    private FlightSearchRepository flightSearchRepository;

    @Override
    public void deleteFlight(long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public FlightResponseDto addFlight(FlightRequestDto requestDto) {
        Flight flight = Flight.builder()
                .departureAirport(airportService.findAirportById(requestDto.getDepartureAirportId()))
                .arrivalAirport(airportService.findAirportById(requestDto.getArrivalAirportId()))
                .departureDateTime(requestDto.getDepartureAt())
                .arrivalDateTime(requestDto.getArrivalAt())
                .price(requestDto.getPrice())
                .build();

        return modelMapper.map(flightRepository.save(flight),FlightResponseDto.class);
    }

    @Override
    public FlightResponseDto updateFlight(FlightRequestDto requestDto, long id) {
        Flight flight = findFlightById(id);
        flight.setPrice(requestDto.getPrice());
        flight.setArrivalDateTime(requestDto.getArrivalAt());
        flight.setDepartureDateTime(requestDto.getDepartureAt());
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
    public FlightSearchResponseDto getFlightSearch(FlightySearchRequestDto flightySearchRequestDto) {
        FlightSearchResponseDto dto = new FlightSearchResponseDto();
        dto.setDepartureFlights(departureFlights(flightySearchRequestDto.getDepartureFlightRequestDto()));

        if (flightySearchRequestDto.getReturnFlightRequestDto() != null){
            dto.setReturnFlights(returnFlights(flightySearchRequestDto.getReturnFlightRequestDto()));
        }
        return dto;
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
                    .arrivalDateTime(req.getArrivalAt())
                    .departureDateTime(req.getDepartureAt())
                    .build();
            flightList.add(flight);
        }
        flightRepository.saveAll(flightList);
    }

    private List<FlightResponseDto> departureFlights(DepartureFlightRequestDto requestDto){
        List<Flight> flightList = flightSearchRepository.getFlight(requestDto);
        List<FlightResponseDto> dtoList = new ArrayList<>();
        for (Flight fl : flightList){
            dtoList.add(modelMapper.map(fl,FlightResponseDto.class));
        }
        return dtoList;
    }

    private List<FlightResponseDto> returnFlights(DepartureFlightRequestDto requestDto){
        List<Flight> flightList = flightSearchRepository.getFlight(requestDto);
        List<FlightResponseDto> dtoList = new ArrayList<>();

        for (Flight fl : flightList){
            dtoList.add(modelMapper.map(fl,FlightResponseDto.class));
        }
        return dtoList;
    }
}
