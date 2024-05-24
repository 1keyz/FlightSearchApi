package com.example.flightsearchapi.repositories;

import com.example.flightsearchapi.model.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Long> {
}
