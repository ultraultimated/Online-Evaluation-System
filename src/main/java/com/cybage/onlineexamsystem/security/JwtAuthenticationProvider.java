package com.cybage.onlineexamsystem.security;


import com.cybage.onlineexamsystem.model.JwtAuthenticationToken;
import com.cybage.onlineexamsystem.model.JwtUserDetails;
import com.cybage.onlineexamsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    JwtValidator jwtValidator;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken)usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        User jwtUser = jwtValidator.validate(token);
        if(jwtUser == null){
            throw new RuntimeException("JWT token is incorrect");
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(String.valueOf(jwtUser.getUserType()));

        System.out.print(new JwtUserDetails(jwtUser.getUsername(), token, jwtUser.getUserId(), grantedAuthorities));
        return new JwtUserDetails(jwtUser.getUsername(),token,jwtUser.getUserId(),grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
