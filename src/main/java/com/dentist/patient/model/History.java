package com.dentist.patient.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Primary key")
    private Long id;

    @Column(name = "date", nullable = false)
    @ApiModelProperty(notes = "History event date")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "diagnose_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ApiModelProperty(notes = "Diagnose linked to the current history object")
    private Diagnose diagnose;

    @Column(name = "diagnose_description", nullable = false)
    @ApiModelProperty(notes = "Diagnose description")
    private String diagnoseDescription;

    @Column(name = "tooth_code", nullable = false)
    @ApiModelProperty(notes = "Tooth code")
    private String toothCode;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "manipulation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ApiModelProperty(notes = "Manipulation linked to the current history object")
    private Manipulation manipulation;

    @Column(name = "manipulation_description", nullable = false)
    @ApiModelProperty(notes = "Manipulation description")
    private String manipulationDescription;

    @Column(name = "minutes_counter")
    @ApiModelProperty(notes = "Minutes counter for anastasia")
    private Integer minutesCounter;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ApiModelProperty(notes = "Patient linked to the current history object")
    private Patient patient;

    /**
     * Constructors, getters and setters
     */
    public History() {

    }

    public History(Date date, Diagnose diagnose, String toothCode, Manipulation manipulation,
                   Integer minutesCounter, Patient patient, String diagnoseDescription,
                   String manipulationDescription) {
        this.date = date;
        this.diagnose = diagnose;
        this.toothCode = toothCode;
        this.manipulation = manipulation;
        this.minutesCounter = minutesCounter;
        this.patient = patient;
        this.diagnoseDescription = diagnoseDescription;
        this.manipulationDescription = manipulationDescription;
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

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    public String getToothCode() {
        return toothCode;
    }

    public void setToothCode(String toothCode) {
        this.toothCode = toothCode;
    }

    public Manipulation getManipulation() {
        return manipulation;
    }

    public void setManipulation(Manipulation manipulation) {
        this.manipulation = manipulation;
    }

    public Integer getMinutesCounter() {
        return minutesCounter;
    }

    public void setMinutesCounter(Integer minutesCounter) {
        this.minutesCounter = minutesCounter;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDiagnoseDescription() {
        return diagnoseDescription;
    }

    public void setDiagnoseDescription(String diagnoseDescription) {
        this.diagnoseDescription = diagnoseDescription;
    }

    public String getManipulationDescription() {
        return manipulationDescription;
    }

    public void setManipulationDescription(String manipulationDescription) {
        this.manipulationDescription = manipulationDescription;
    }
}