package com.example.flightsearchapi.repositories.factory;


import com.example.flightsearchapi.dtos.requests.DepartureFlightRequestDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilterFlightFactory {

    public static List<Predicate> predicates (CriteriaBuilder cb , Root root , DepartureFlightRequestDto requestDto){
        List<Predicate> predicateList = new ArrayList<>();
        Join join ;

        Predicate departureAirportPredicate = cb.equal(getJoin("departureAirport",root).get("id"),requestDto.getDepartureAirportId());
        Predicate arrivalAirportPredicate = cb.equal(getJoin("arrivalAirport",root).get("id"),requestDto.getArrivalAirportId());
       // Predicate departureAirportPredicate = cb.equal(root.get("departureAirport"),requestDto.getDepartureAirportId());
       // Predicate arrivalAirportPredicate = cb.equal(root.get("arrivalAirport"),requestDto.getArrivalAirportId());
        Predicate departureAtPredicate = cb.equal(cb.function("DATE",LocalDate.class,root.get("departureDateTime")),
               requestDto.getDepartureAt());

        predicateList.add(departureAirportPredicate);
        predicateList.add(arrivalAirportPredicate);
        predicateList.add(departureAtPredicate);

        return predicateList;
    }

    public static Join getJoin(String str , Root root){
        Join join;

        if (str.startsWith("departure")){
            join = root.join("departureAirport");
        }else {
            join = root.join("arrivalAirport");
        }
        return join;
    }






    //  Predicate departureAtPredicate = cb.equal(cb.function("DATE",LocalDate.class,root.get("departureAt")), requestDto.getDepartureAt());
    // burda localdatetime olan uçuş saatlerini alarak localdate'e çevirdik çünkü uçuş ararken sadece gün ay yıl olarak giriliyor!!!

}
