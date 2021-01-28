package com.dentist.patient.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dentist.patient.model.Diagnose;
import com.dentist.patient.model.Manipulation;
import com.dentist.patient.model.Patient;
import com.dentist.patient.repository.IDiagnoseRepository;
import com.dentist.patient.repository.IPatientRepository;
import com.dentist.patient.repository.IManipulationRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentist.patient.model.History;
import com.dentist.patient.repository.IHistoryRepository;

@RestController
@RequestMapping("/api/patient")
@Api(value = "History REST Endpoint", description = "Shows the history info")
public class HistoryController {

    @Autowired
    IPatientRepository iPatientRepository;

    @Autowired
    IHistoryRepository iHistoryRepository;

    @Autowired
    IManipulationRepository iManipulationRepository;

    @Autowired
    IDiagnoseRepository iDiagnoseRepository;

    /**
     * Find a history by patient id
     *
     * @param patientId the patient id
     * @return ResponseEntity
     */
    @GetMapping("/{patientId}/history")
    public ResponseEntity<List<History>> getHistoryByPatient(@PathVariable("patientId") Long patientId) {

        try {
            List<History> history = new ArrayList<>(iHistoryRepository.findByPatientId(patientId));

            if (history.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(history, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Find a history by patient id and history id
     *
     * @param patientId the patient id
     * @param id history object id
     * @return ResponseEntity
     */
    @GetMapping("/{patientId}/history/{id}")
    public ResponseEntity<History> getHistoryById(@PathVariable("patientId") Long patientId,
                                                  @PathVariable("id") Long id) {
        Optional<History> historyData = iHistoryRepository.findById(id);

        if (historyData.isPresent()) {
            History history = historyData.get();
            if (!patientId.equals(history.getPatient().getId())) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(history, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create and save a history by patient id
     *
     * @param patientId the patient id
     * @param history history object
     * @return ResponseEntity
     */
    @PostMapping("/{patientId}/history")
    public ResponseEntity<History> createHistory(@PathVariable("patientId") Long patientId,
                                                 @RequestBody History history) {
        try {
            Optional<Patient> patient = iPatientRepository.findById(patientId);
            history.setPatient(patient.get());

            Optional<Manipulation> manipulationData = iManipulationRepository.findById(history.getManipulation().getId());
            history.setManipulation(manipulationData.get());

            Optional<Diagnose> diagnoseData = iDiagnoseRepository.findById(history.getDiagnose().getId());
            history.setDiagnose(diagnoseData.get());

            return new ResponseEntity<>(iHistoryRepository.save(history), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Save or update a history by patient id and history id
     *
     * @param patientId the patient id
     * @param id history object id
     * @param history history object
     * @return ResponseEntity
     */
    @PutMapping("/{patientId}/history/{id}")
    public ResponseEntity<History> updateHistory(@PathVariable("patientId") Long patientId,
                                                 @PathVariable("id") Long id, @RequestBody History history) {
        Optional<History> historyData = iHistoryRepository.findById(id);

        if (historyData.isPresent()) {
            History _history = historyData.get();
            if (!patientId.equals(_history.getPatient().getId())) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            _history.setDate(history.getDate());
            _history.setDiagnose(history.getDiagnose());
            _history.setToothCode(history.getToothCode());
            _history.setManipulation(history.getManipulation());
            _history.setMinutesCounter(history.getMinutesCounter());
            _history.setDiagnoseDescription(history.getDiagnoseDescription());
            _history.setManipulationDescription(history.getManipulationDescription());
            return new ResponseEntity<>(iHistoryRepository.save(_history), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a history by patient id and history id
     *
     * @param patientId the patient id
     * @param id history object id
     * @return ResponseEntity
     */
    @DeleteMapping("/{patientId}/history/{id}")
    public ResponseEntity<HttpStatus> deleteHistory(@PathVariable("patientId") Long patientId,
                                                    @PathVariable("id") Long id) {
        try {
            Optional<History> historyData = iHistoryRepository.findById(id);

            if (historyData.isPresent()) {
                History history = historyData.get();
                if (!patientId.equals(history.getPatient().getId())) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            iHistoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}