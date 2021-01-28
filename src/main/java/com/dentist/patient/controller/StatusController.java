package com.dentist.patient.controller;

import com.dentist.patient.model.*;
import com.dentist.patient.repository.*;
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
@Api(value = "Patient REST Endpoint", description = "Shows the status info")
public class StatusController {
    @Autowired
    IPatientRepository iPatientRepository;

    @Autowired
    IStatusRepository iStatusRepository;

    /**
     * Find status by patient id
     *
     * @param patientId the patient id
     * @return ResponseEntity
     */
    @GetMapping("/{patientId}/status")
    public ResponseEntity<List<Status>> getStatusByPatient(@PathVariable("patientId") Long patientId) {

        try {
            List<Status> status = new ArrayList<>(iStatusRepository.findByPatientId(patientId));

            if (status.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Find status by patient id and status id
     *
     * @param patientId the patient id
     * @param id status object id
     * @return ResponseEntity
     */
    @GetMapping("/{patientId}/status/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable("patientId") Long patientId,
                                                @PathVariable("id") Long id) {
        Optional<Status> statusData = iStatusRepository.findById(id);

        if (statusData.isPresent()) {
            Status status = statusData.get();
            if (!patientId.equals(status.getPatient().getId())) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create and save a status by patient id
     *
     * @param patientId the patient id
     * @param status patient status object
     * @return ResponseEntity
     */
    @PostMapping("/{patientId}/status")
    public ResponseEntity<Status> createStatus(@PathVariable("patientId") Long patientId,
                                               @RequestBody Status status) {
        try {
            Optional<Patient> patient = iPatientRepository.findById(patientId);
            status.setPatient(patient.get());

            return new ResponseEntity<>(iStatusRepository.save(status), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Save or update a status by patient id and status id
     *
     * @param patientId the patient id
     * @param id status object id
     * @param status patient status object
     * @return ResponseEntity
     */
    @PutMapping("/{patientId}/status/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable("patientId") Long patientId,
                                               @PathVariable("id") Long id, @RequestBody Status status) {
        Optional<Status> statusData = iStatusRepository.findById(id);

        if (statusData.isPresent()) {
            Status _status = statusData.get();
            if (!patientId.equals(_status.getPatient().getId())) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            _status.setDate(status.getDate());
            _status.setToothStatus(status.getToothStatus());
            return new ResponseEntity<>(iStatusRepository.save(_status), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete status by patient id and status id
     *
     * @param patientId the patient id
     * @param id status object id
     * @return ResponseEntity
     */
    @DeleteMapping("/{patientId}/status/{id}")
    public ResponseEntity<HttpStatus> deleteStatus(@PathVariable("patientId") Long patientId,
                                                   @PathVariable("id") Long id) {
        try {
            Optional<Status> statusData = iStatusRepository.findById(id);

            if (statusData.isPresent()) {
                Status status = statusData.get();
                if (!patientId.equals(status.getPatient().getId())) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            iStatusRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}