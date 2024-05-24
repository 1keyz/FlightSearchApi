package com.example.flightsearchapi.security;

import com.example.flightsearchapi.advice.exception.LoginException;
import com.example.flightsearchapi.model.entities.User;
import com.example.flightsearchapi.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userService.getUserByEmail(email);
        if (bCryptPasswordEncoder.matches(password,user.getPassword())){
            return new UsernamePasswordAuthenticationToken(email,password,new HashSet<>());
        }else {
            throw new LoginException("your password or email is wrond check it !");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
