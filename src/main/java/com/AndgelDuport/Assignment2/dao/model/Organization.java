package com.AndgelDuport.Assignment2.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organizationID", nullable = false)
    private Integer organizationID;

    public Integer getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(Integer organizationID) {
        this.organizationID = organizationID;
    }

    @Column(name = "name")
    private String name;
}
