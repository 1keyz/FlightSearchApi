package com.example.flightsearchapi.repositories.impl;

import com.example.flightsearchapi.dtos.requests.DepartureFlightRequestDto;
import com.example.flightsearchapi.dtos.requests.FlightySearchRequestDto;
import com.example.flightsearchapi.model.entities.Flight;
import com.example.flightsearchapi.repositories.FlightSearchRepository;
import com.example.flightsearchapi.repositories.factory.FilterFlightFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class FlightSearchRepositoryImpl implements FlightSearchRepository {
    private EntityManager em;

    public List<Flight> getFlight(DepartureFlightRequestDto requestDto){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Flight.class);
        Root flight = cq.from(Flight.class);

        List<Predicate> predicateList = FilterFlightFactory.predicates(cb,flight,requestDto);

        cq.where(predicateList.toArray(new Predicate[0]));

        TypedQuery<Flight> query = em.createQuery(cq);

        return query.getResultList();
    }


}
