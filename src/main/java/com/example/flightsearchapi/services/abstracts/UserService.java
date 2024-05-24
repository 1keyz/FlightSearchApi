package com.example.flightsearchapi.services.abstracts;

import com.example.flightsearchapi.model.entities.User;

public interface UserService {

     User getUserByEmail(String email);
}
