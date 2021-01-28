package com.dentist.patient.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Primary key")
    private Long id;

    @Column(name = "first_name", nullable = false)
    @ApiModelProperty(notes = "Patient first name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @ApiModelProperty(notes = "Patient last name")
    private String lastName;

    @Column(name = "egn", unique = true, nullable = false)
    @ApiModelProperty(notes = "Personal Identification Number")
    private Long egn;

    /**
     * Constructors, getters and setters
     */
    public Patient() {

    }

    public Patient(String firstName, String lastName, Long egn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getEgn() {
        return egn;
    }

    public void setEgn(Long egn) {
        this.egn = egn;
    }
}