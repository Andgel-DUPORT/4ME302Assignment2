package com.AndgelDuport.Assignment2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "therapy")
public class Therapy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "therapyID", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "User_IDpatient")
    private Integer User_IDpatient;

    @Column(name = "User_IDmed")
    private Integer User_IDmed;

    @Column(name = "therapy_list_idtherapylist")
    private Integer TherapyList_IDtherapylist;
}
