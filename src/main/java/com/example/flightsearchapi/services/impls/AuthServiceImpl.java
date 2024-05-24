package com.example.flightsearchapi.services.impls;

import com.example.flightsearchapi.dtos.requests.LoginRequestDto;
import com.example.flightsearchapi.dtos.requests.UserRequestDto;
import com.example.flightsearchapi.dtos.responses.LoginResponseDto;
import com.example.flightsearchapi.dtos.responses.UserResponseDto;
import com.example.flightsearchapi.model.entities.User;
import com.example.flightsearchapi.repositories.UserRepository;
import com.example.flightsearchapi.security.jwt.JwtService;
import com.example.flightsearchapi.services.abstracts.AuthService;
import com.example.flightsearchapi.services.abstracts.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private BCryptPasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private FlightService flightService;

    public AuthServiceImpl(UserRepository userRepository, ModelMapper modelMapper,
                           BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                           @Lazy JwtService jwtService, FlightService flightService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.flightService = flightService;
    }

    @Override
    public UserResponseDto register(UserRequestDto requestDto) {
        User user = User.builder()
                .name(requestDto.getName())
                .surname(requestDto.getSurname())
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .roleEnum(requestDto.getRoleEnum())
                .build();

        return modelMapper.map(userRepository.save(user),UserResponseDto.class);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.getEmail(),requestDto.getPassword()));

        LoginResponseDto loginResponseDto = LoginResponseDto.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .token(jwtService.generateToken(requestDto.getEmail()))
                .build();

        return loginResponseDto;
    }

    public UserResponseDto buyFlight(int flightCode){
        User user = getAuthenticatedUser();
        user.setFlight(flightService.buyFlightByFlightCode(flightCode));
        return modelMapper.map(userRepository.save(user),UserResponseDto.class);
    }

    private User getAuthenticatedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object ob = authentication.getPrincipal();

        if (authentication != null && authentication.isAuthenticated()){
            User user = userRepository.getUserByEmail(ob.toString()).orElseThrow(() ->
                    new RuntimeException("user not authentication"));
            return user;
        }
        return null;
    }

}
