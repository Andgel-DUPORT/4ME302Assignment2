package com.AndgelDuport.Assignment2.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomAuthoritiesMapper implements GrantedAuthoritiesMapper {

    @Override
    public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
        List<GrantedAuthority> mappedAuthorities = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().startsWith("ROLE_")) {
                mappedAuthorities.add(authority);
            } else {
                mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + authority.getAuthority()));
            }
        }
        return mappedAuthorities;
    }
}