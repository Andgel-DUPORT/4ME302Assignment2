package com.AndgelDuport.Assignment2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organizationID", nullable = false)
    private Long organizationID;

    public Long getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(Long organizationID) {
        this.organizationID = organizationID;
    }

    @Column(name = "name")
    private String name;
}
