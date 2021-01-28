package com.dentist.patient.controller;

import com.dentist.patient.model.Diagnose;
import com.dentist.patient.repository.IDiagnoseRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diagnose")
@Api(value = "Diagnose Resource REST Endpoint", description = "Shows the diagnose info")
public class DiagnoseController {

    @Autowired
    IDiagnoseRepository iDiagnoseRepository;

    /**
     * Find all diagnoses
     *
     * @return ResponseEntity
     */
    @GetMapping("")
    public ResponseEntity<List<Diagnose>> getAllDiagnoses() {
        try {
            List<Diagnose> diagnose = new ArrayList<>(iDiagnoseRepository.findAll());
            if (diagnose.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(diagnose, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Find a diagnose by id
     *
     * @param id diagnose object id
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Diagnose> getDiagnoseById(@PathVariable("id") long id) {
        Optional<Diagnose> diagnoseData = iDiagnoseRepository.findById(id);

        if (diagnoseData.isPresent()) {
            return new ResponseEntity<>(diagnoseData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create and save a diagnose
     *
     * @param diagnose diagnose object
     * @return ResponseEntity
     */
    @PostMapping("")
    public ResponseEntity<Diagnose> createDiagnose(@RequestBody Diagnose diagnose) {
        try {
            Diagnose _diagnose = iDiagnoseRepository.save(new Diagnose(diagnose.getName()));
            return new ResponseEntity<>(_diagnose, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Save or update a diagnose
     *
     * @param id diagnose object id
     * @param diagnose diagnose object
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Diagnose> updateDiagnose(@PathVariable("id") long id,
                                                   @RequestBody Diagnose diagnose) {
        Optional<Diagnose> diagnoseData = iDiagnoseRepository.findById(id);

        if (diagnoseData.isPresent()) {
            Diagnose _diagnose = diagnoseData.get();
            _diagnose.setName(diagnose.getName());
            return new ResponseEntity<>(iDiagnoseRepository.save(_diagnose), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}