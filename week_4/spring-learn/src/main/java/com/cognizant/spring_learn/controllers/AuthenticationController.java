package com.cognizant.spring_learn.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate") //When someone sends a GET request to /authenticate, run this method
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start of /authenticate");
        LOGGER.debug("Authorization Header: {}", authHeader);
        String user = getUser(authHeader);
        String token = generateJWT(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token); // Currently empty, can be extended for JWT later
        
        LOGGER.info("End of /authenticate");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("Start of getUser");

        // Removing "Basic " prefix and trim the rest
        String encodedCredentials = authHeader.substring("Basic ".length()).trim();
        LOGGER.debug("Encoded credentials: {}", encodedCredentials);

        // Decoding base64 to original username:password string
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        LOGGER.debug("Decoded credentials: {}", decodedString);

        // Splittig at ":" and return the username (before the colon)
        String username = decodedString.split(":")[0];
        LOGGER.debug("Extracted username: {}", username);

        LOGGER.debug("End of getUser");
        return username;
    }

    //generateJWT function generates a token based on the user name passed to it.
    //It uses the HS256 algorithm and a secret key to sign the token.
    private String generateJWT(String User){
        LOGGER.debug("Start of generateJWT");
        String secret = "secretKey69@gobhiNALLA789456123##MARVEL";
        SecretKey key = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HS256.getJcaName());
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(User);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date((new Date()).getTime() + 5 * 60 * 1000)); // Token valid for 20 minutes
        builder.signWith(key,SignatureAlgorithm.HS256);
        
        String token = builder.compact();
        LOGGER.debug("Generated JWT: {}", token);
        LOGGER.debug("END of generateJWT"); 
        return token;
        
    }
}

// @RestController: Tells Spring this class handles web API calls.

// @GetMapping: Tells Spring which HTTP request this method should respond to (like /authenticate).

// @RequestHeader: Tells Spring to grab data from an incoming HTTP header.
//It handles GET requests to /authenticate, reads the Authorization header, logs it, and returns a JSON response with an empty "token"