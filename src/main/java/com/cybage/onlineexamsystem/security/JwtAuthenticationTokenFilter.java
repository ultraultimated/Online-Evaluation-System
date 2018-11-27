package com.cybage.onlineexamsystem.security;

import com.cybage.onlineexamsystem.model.JwtAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
    public JwtAuthenticationTokenFilter() {
        super("/rest/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String header = httpServletRequest.getHeader("Authorization");

        if(header == null || !header.startsWith("Token ")){
            System.out.print(header);
            throw new RuntimeException("JWT Token is missing");
        }

        String authenticationToken = header.substring((6));
        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(authenticationToken);

        return getAuthenticationManager().authenticate(jwtAuthenticationToken);
    }
}
