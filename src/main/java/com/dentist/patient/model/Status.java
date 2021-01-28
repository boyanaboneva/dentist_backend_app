package com.dentist.patient.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Primary key")
    private Long id;

    @Column(name = "date", nullable = false)
    @ApiModelProperty(notes = "Status event date")
    private Date date;

    @Column(name = "tooth_status", nullable = false, columnDefinition = "TEXT")
    @ApiModelProperty(notes = "Tooth status")
    private String toothStatus;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ApiModelProperty(notes = "Patient linked to the current status object")
    private Patient patient;

    /**
     * Constructors, getters and setters
     */
    public Status() {

    }

    public Status(Date date, String toothStatus, Patient patient) {
        this.date = date;
        this.toothStatus = toothStatus;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getToothStatus() {
        return toothStatus;
    }

    public void setToothStatus(String toothStatus) {
        this.toothStatus = toothStatus;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}