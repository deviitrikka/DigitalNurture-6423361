package com.cognizant.spring_learn.security;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    // This class can be used to implement JWT-based authorization logic.
    // It would typically extend BasicAuthenticationFilter to handle JWT tokens in the request headers.
    // we can override methods like doFilterInternal to extract and validate JWT tokens.
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

        @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Start");
        String header = req.getHeader("Authorization");
        LOGGER.debug(header);
        
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        if (authentication == null) {
            LOGGER.warn("Invalid or missing JWT. Rejecting request.");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
        LOGGER.info("End");
    }
   
        private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            // parse the token.
            Jws<Claims> jws;
            try {
                byte[] keyBytes = "secretKey69@gobhiNALLA789456123##MARVEL".getBytes(); // key must be at least 256 bits for HS256
                jws = Jwts.parserBuilder()
                        .setSigningKey(Keys.hmacShaKeyFor(keyBytes))
                        .setAllowedClockSkewSeconds(300)
                        .build()
                        .parseClaimsJws(token.replace("Bearer ", ""));
                String user = jws.getBody().getSubject();
                LOGGER.debug(user);
                // If token is valid, return an authentication object with the user details
                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, List.of(new SimpleGrantedAuthority("ROLE_USER")));
                }
            } catch (JwtException ex) {
                LOGGER.error("JWT exception: {}", ex.getMessage());
                return null;
            }
            return null;
        }
        return null;
    }

    
}
