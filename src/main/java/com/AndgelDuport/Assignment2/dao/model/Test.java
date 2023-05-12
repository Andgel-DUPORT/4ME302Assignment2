package com.AndgelDuport.Assignment2.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "testID", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "Therapy_IDtherapy")
    private Integer Therapy_IDtherapy;
}
