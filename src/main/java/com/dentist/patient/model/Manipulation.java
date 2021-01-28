package com.dentist.patient.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "manipulation")
public class Manipulation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Primary key")
    private Long id;

    @Column(name = "manipulation_type", nullable = false)
    @ApiModelProperty(notes = "Manipulation type")
    private String manipulationType;

    @Column(name = "manipulation_code", nullable = false)
    @ApiModelProperty(notes = "Manipulation code")
    private Long manipulationCode;

    @Column(name = "nhif_price_under_18")
    @ApiModelProperty(notes = "National Health Insurance Fund price under 18 years old")
    private Double nhifPriceUnder18;

    @Column(name = "nhif_price_over_18")
    @ApiModelProperty(notes = "National Health Insurance Fund price over 18 years old")
    private Double nhifPriceOver18;

    @Column(name = "patient_price_under_18")
    @ApiModelProperty(notes = "Patient price under 18 years old")
    private Double patientPriceUnder18;

    @Column(name = "patient_price_over_18")
    @ApiModelProperty(notes = "Patient price over 18 years old")
    private Double patientPriceOver18;

    /**
     * Constructors, getters and setters
     */
    public Manipulation() {

    }

    public Manipulation(String manipulationType, Long manipulationCode, Double nhifPriceUnder18,
                        Double nhifPriceOver18, Double patientPriceUnder18, Double patientPriceOver18) {
        this.manipulationType = manipulationType;
        this.manipulationCode = manipulationCode;
        this.nhifPriceUnder18 = nhifPriceUnder18;
        this.nhifPriceOver18 = nhifPriceOver18;
        this.patientPriceUnder18 = patientPriceUnder18;
        this.patientPriceOver18 = patientPriceOver18;
    }

    public Long getId() {
        return id;
    }

    public String getManipulationType() {
        return manipulationType;
    }

    public void setManipulationType(String manipulationType) {
        this.manipulationType = manipulationType;
    }

    public Long getManipulationCode() {
        return manipulationCode;
    }

    public void setManipulationCode(Long manipulationCode) {
        this.manipulationCode = manipulationCode;
    }

    public Double getNhifPriceUnder18() {
        return nhifPriceUnder18;
    }

    public void setNhifPriceUnder18(Double nhifPriceUnder18) {
        this.nhifPriceUnder18 = nhifPriceUnder18;
    }

    public Double getNhifPriceOver18() {
        return nhifPriceOver18;
    }

    public void setNhifPriceOver18(Double nhifPriceOver18) {
        this.nhifPriceOver18 = nhifPriceOver18;
    }

    public Double getPatientPriceUnder18() {
        return patientPriceUnder18;
    }

    public void setPatientPriceUnder18(Double patientPriceUnder18) {
        this.patientPriceUnder18 = patientPriceUnder18;
    }

    public Double getPatientPriceOver18() {
        return patientPriceOver18;
    }

    public void setPatientPriceOver18(Double patientPriceOver18) {
        this.patientPriceOver18 = patientPriceOver18;
    }
}
