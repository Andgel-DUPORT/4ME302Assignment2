package com.AndgelDuport.Assignment2.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "therapy_list")
public class TherapyList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "therapy_listID", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "Medicine_IDmedicine")
    private Integer Medicine_IDmedicine;

    @Column(name = "Dosage")
    private String Dosage;
}
