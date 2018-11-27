package com.cybage.onlineexamsystem.security;

import com.cybage.onlineexamsystem.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

/**
 * Created by neelp on 11/16/2018.
 */
@Component
public class JwtGenerator {
    public String generate(User jwtUser){

        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUsername());
        claims.put("userId",jwtUser.getUserId());
        claims.put("userType",jwtUser.getUserType());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,"cybage")
		        .compact();
    }
}
