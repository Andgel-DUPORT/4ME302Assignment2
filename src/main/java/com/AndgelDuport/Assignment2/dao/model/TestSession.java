package com.AndgelDuport.Assignment2.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "test_session")
public class TestSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_SessionID", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "test_type")
    private Integer test_type;

    @Column(name = "test_IDtest")
    private Integer test_IDtest;

    @Column(name = "DataURL")
    private String DataURL;
}
