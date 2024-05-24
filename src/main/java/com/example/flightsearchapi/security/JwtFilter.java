package com.example.flightsearchapi.security;

import com.example.flightsearchapi.model.entities.User;
import com.example.flightsearchapi.security.jwt.JwtService;
import com.example.flightsearchapi.security.service.CustomUserDetailService;
import com.example.flightsearchapi.services.abstracts.AuthService;
import com.example.flightsearchapi.services.abstracts.UserService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;

@Configuration
public class JwtFilter extends OncePerRequestFilter {
    private JwtService jwtService;
    private CustomUserDetailService customUserDetailService;
    private UserService userService;

    public JwtFilter(JwtService jwtService, @Lazy CustomUserDetailService customUserDetailService,@Lazy UserService userService) {
        this.jwtService = jwtService;
        this.customUserDetailService = customUserDetailService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String email;
        String token;

        if (header != null && header.startsWith("Bearer ")){
            token = header.substring(7);

            try {
                email = jwtService.extractUser(token);
            }catch (JwtException ex){
                throw new AuthenticationException(ex.getMessage());
            }


            User user = userService.getUserByEmail(email);
            UserDetails userDetail = customUserDetailService.loadUserByUsername(email);

            if (jwtService.validateToken(token,userDetail)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getEmail(),
                        user.getPassword() , userDetail.getAuthorities());
                authenticationToken.setDetails(userDetail);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
