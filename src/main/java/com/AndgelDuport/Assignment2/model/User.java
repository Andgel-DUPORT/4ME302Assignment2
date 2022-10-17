package com.AndgelDuport.Assignment2.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @Column(name = "Userid", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username")
    private String username;

    @Column(name= "email")
    private String email;

    @Column(name = "Role_IDrole")
    private Long Role_IDrole;

    @Column(name = "Organization")
    private Integer Organization;

    @Column(name = "Lat")
    private Float Lat;

    @Column(name = "Long")
    private Float Long;

}
