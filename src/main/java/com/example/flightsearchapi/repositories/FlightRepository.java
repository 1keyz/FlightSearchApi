package com.example.flightsearchapi.repositories;

import com.example.flightsearchapi.model.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query(value = "SELECT * FROM flights WHERE flights.flight_code =:flightCode" , nativeQuery = true)
    Flight getFlightByFlightCode(@Param("flightCode") int flightCode);
}
