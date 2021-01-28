package com.dentist.patient.controller;

import com.dentist.patient.model.Patient;
import com.dentist.patient.repository.IPatientRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
@Api(value = "Patient REST Endpoint", description = "Shows the patient info")
public class PatientController {

    @Autowired
    IPatientRepository iPatientRepository;

    /**
     * Find all patients
     *
     * @param firstName patient first name
     * @param lastName patient last name
     * @param egn patient personal identification number
     * @return ResponseEntity
     */
    @GetMapping("")
    public ResponseEntity<List<Patient>> getAllPatients(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) Long egn) {
        try {
            List<Patient> patient = new ArrayList<>();

            if (firstName != null)
                patient.addAll(iPatientRepository.findByFirstName(firstName));
            else if (lastName != null)
                patient.addAll(iPatientRepository.findByLastName(lastName));
            else if (egn != null)
                patient.addAll(iPatientRepository.findByEgn(egn));
            else
                patient.addAll(iPatientRepository.findAll());

            if (patient.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(patient, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Find patient by id
     *
     * @param id patient object id
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") long id) {
        Optional<Patient> patientData = iPatientRepository.findById(id);

        if (patientData.isPresent()) {
            return new ResponseEntity<>(patientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create and save a patient
     *
     * @param patient patient object
     * @return ResponseEntity
     */
    @PostMapping("")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        try {
            Patient _patient = iPatientRepository
                    .save(new Patient(patient.getFirstName(), patient.getLastName(), patient.getEgn()));
            return new ResponseEntity<>(_patient, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Save or update a patient by id
     *
     * @param id patient object id
     * @param patient patient object
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
        Optional<Patient> patientData = iPatientRepository.findById(id);

        if (patientData.isPresent()) {
            Patient _patient = patientData.get();
            _patient.setFirstName(patient.getFirstName());
            _patient.setLastName(patient.getLastName());
            _patient.setEgn(patient.getEgn());
            return new ResponseEntity<>(iPatientRepository.save(_patient), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a patient by id
     *
     * @param id patient object id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") long id) {
        try {
            iPatientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}