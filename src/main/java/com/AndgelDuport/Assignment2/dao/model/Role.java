package com.AndgelDuport.Assignment2.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleID", nullable = false)
    private Integer roleID;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
}
