package com.AndgelDuport.Assignment2.dao.model;

import lombok.Data;

@Data
public class UserRole {

    private Integer id;
    private String username;
    private String email;
    private Integer Role_IDrole;
    private Integer Organization;
    private Float Lat;
    private Float Long;
    private String roleName;

    private String organizationName;

    public UserRole(Integer id, String username, String email, Integer role_IDrole, Integer organization, Float lat, Float aLong, String roleName, String organizationName) {
        this.id = id;
        this.username = username;
        this.email = email;
        Role_IDrole = role_IDrole;
        Organization = organization;
        Lat = lat;
        Long = aLong;
        this.roleName = roleName;
        this.organizationName = organizationName;
    }
}
