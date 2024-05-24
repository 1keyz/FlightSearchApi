package com.example.flightsearchapi.security.jwt;

import com.example.flightsearchapi.security.service.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public interface JwtService {

    String generateToken(String email);

    Boolean validateToken(String token , UserDetails userDetail);
    String extractUser(String token);
    Date extractExprition(String token);
    String createToken(String email , Map<String,String> claim);
    Key getSignKey();
}
