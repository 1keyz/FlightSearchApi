package com.example.flightsearchapi.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Data
public class AbstractId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
