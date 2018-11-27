package com.cybage.onlineexamsystem.security;

import com.cybage.onlineexamsystem.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

/**
 * Created by neelp on 11/16/2018.
 */

@Component
public class JwtValidator {

    private String secret = "cybage";

    public User validate(String token){
        User jwtUser = null;

        try{
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new User();
            jwtUser.setUsername(body.getSubject());
            jwtUser.setUserId(Integer.parseInt((String)body.get("userId")));
            String role = (String) body.get("role");
            jwtUser.setUserType(role);
        }
        catch (Exception e){
            System.out.print(e);
        }
        return jwtUser;
    }
}
