package com.example.flightsearchapi.services.impls;

import com.example.flightsearchapi.advice.exception.NotFoundException;
import com.example.flightsearchapi.model.entities.User;
import com.example.flightsearchapi.repositories.UserRepository;
import com.example.flightsearchapi.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email).orElseThrow( () -> new NotFoundException("User Not Found"));
    }
}
