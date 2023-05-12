package com.AndgelDuport.Assignment2.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medicineID", nullable = false)
    private Long medicineID;

    public Long getId() {
        return medicineID;
    }

    public void setId(Long id) {
        this.medicineID = id;
    }

    @Column(name="name")
    private String name;
}
