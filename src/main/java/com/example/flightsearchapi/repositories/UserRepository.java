package com.example.flightsearchapi.repositories;

import com.example.flightsearchapi.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> getUserByEmail(String email);
}
