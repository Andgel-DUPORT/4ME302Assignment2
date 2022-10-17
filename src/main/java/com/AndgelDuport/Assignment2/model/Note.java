package com.AndgelDuport.Assignment2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "noteID", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Test_Session_IDtest_session")
    private Integer Test_Session_IDtest_session;

    @Column(name = "note")
    private String note;

    @Column(name = "User_IDmed")
    private Integer User_IDmed;

}
