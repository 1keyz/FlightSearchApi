package com.example.flightsearchapi.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "flights")
public class Flight extends AbstractId {
    @Column(name = "flight_code")
    private int flightCode;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Column(name = "departure_date_time")
    private LocalDateTime departureDateTime;

    @Column(name = "arrival_date_time")
    private LocalDateTime arrivalDateTime;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "flight" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @Column(name = "user_list")
    private List<User> users;

}
