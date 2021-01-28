package com.dentist.patient.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "diagnose")
public class Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Primary key")
    private Long id;

    @Column(name = "name", nullable = false)
    @ApiModelProperty(notes = "Diagnose name")
    private String name;

    /**
     * Constructors, getters and setters
     */
    public Diagnose() {

    }

    public Diagnose(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}