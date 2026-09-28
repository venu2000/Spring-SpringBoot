package com.flm.security;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.flm.exception.JwtTokenExpiredException;
import com.flm.model.Authority;
import com.flm.model.Person;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTService {

    @Value("${jwt.secret}")
    private String secretKeyBase64;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

//    public String generateToken(String username) {
//        return generateToken(new HashMap<>(), username);
//    }
//
//    public String generateToken(Map<String, Object> extraClaims, String username) {
//    	
//    	
//    	
//        return buildToken(extraClaims, username, jwtExpiration);
//    }
    
    public String generateToken(Person person) {

        Map<String, Object> claims = new HashMap<>();

        // Get roles from Person -> Authority -> role
        List<String> roles = person.getAuthorities()
                .stream()
                .map(Authority::getRole)
                .toList();

        // Add roles to JWT payload
        claims.put("roles", roles);

        return buildToken(
                claims,
                person.getUserName(),
                jwtExpiration
        );
    }


    private String buildToken(Map<String, Object> extraClaims, String username, long expiration) {
        return Jwts.builder()
                
                .subject(username)
                .claims(extraClaims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey())
                .compact();
    }

    public boolean isTokenValid(String token, String username) {
    	
    	
        final String usernameFromToken = extractUsername(token);
        return (usernameFromToken.equals(username)) 
        		&& !isTokenExpired(token);
        
    	
    }

    private boolean isTokenExpired(String token) {
        
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
    	 try {

    	        return Jwts.parser()
    	                .verifyWith(getSignInKey())
    	                .build()
    	                .parseSignedClaims(token)
    	                .getPayload();

    	    } catch (ExpiredJwtException e) {
//Implemented Custom Exception
    	        throw new JwtTokenExpiredException("Token Expired .....");
    	    }
    }
    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKeyBase64);
        return Keys.hmacShaKeyFor(keyBytes); // returns SecretKey
    }

}
