package com.cybage.onlineexamsystem.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by avishab on 11/16/2018.
 */
public class JwtUserDetails implements UserDetails {
    private String userName;
    private String token;
    private int id;
    private Collection<? extends GrantedAuthority> authorities;


    public JwtUserDetails(String userName, String token, int id, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.token = token;
        this.id = id;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }


    public int getId() {
        return id;
    }

}
