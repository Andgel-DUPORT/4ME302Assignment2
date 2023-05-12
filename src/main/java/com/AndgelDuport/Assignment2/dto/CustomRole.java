package com.AndgelDuport.Assignment2.dto;

import org.springframework.security.core.GrantedAuthority;

public class CustomRole implements GrantedAuthority {
    private String roleName;

    public CustomRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}