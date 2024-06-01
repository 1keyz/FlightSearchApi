package com.example.flightsearchapi.repositories;

import com.example.flightsearchapi.model.entities.Flight;
import org.openapitools.model.FlightSearchRequestDto;
import org.openapitools.model.FlightSearchResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query(value = "SELECT * FROM flights WHERE flights.flight_code =:flightCode" , nativeQuery = true)
    Flight getFlightByFlightCode(@Param("flightCode") int flightCode);


    @Query(value = "SELECT * FROM flights where flights.departure_airport_id = :departureAirportId " +
            "and flights.arrival_airport_id = :arrivalAirportId " +
            "and flights.departure_date_time >= :minDate and flights.departure_date_time <= :maxDate" , nativeQuery = true)
    List<Flight> searchFlight(long departureAirportId , long arrivalAirportId , LocalDateTime minDate , LocalDateTime maxDate);

}

