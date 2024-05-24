package com.example.flightsearchapi.security.service;

import com.example.flightsearchapi.model.entities.User;
import com.example.flightsearchapi.services.abstracts.AuthService;
import com.example.flightsearchapi.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(username);
        return new UserDetail(user);
    }
}
