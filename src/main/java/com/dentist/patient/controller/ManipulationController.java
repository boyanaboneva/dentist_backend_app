package com.dentist.patient.controller;

import com.dentist.patient.model.Manipulation;
import com.dentist.patient.repository.IManipulationRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/manipulation")
@Api(value = "Manipulation Resource REST Endpoint", description = "Shows the manipulation info")
public class ManipulationController {

    @Autowired
    IManipulationRepository iManipulationRepository;

    /**
     * Find all manipulations
     *
     * @return ResponseEntity
     */
    @GetMapping("")
    public ResponseEntity<List<Manipulation>> getAllManipulations() {
        try {
            List<Manipulation> manipulation = new ArrayList<>();
            manipulation.addAll(iManipulationRepository.findAll());

            if (manipulation.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(manipulation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Find a manipulation by code
     *
     * @param code manipulation code
     * @return ResponseEntity
     */
    @GetMapping("/{code}")
    public ResponseEntity<Manipulation> getManipulationByCode(@PathVariable("code") Long code) {
        List<Manipulation> manipulationData = iManipulationRepository.findByManipulationCode(code);

        if (!manipulationData.isEmpty()) {
            Manipulation manipulation = manipulationData.get(0);
            return new ResponseEntity<>(manipulation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create and save a manipulation
     *
     * @param manipulation manipulation object
     * @return ResponseEntity
     */
    @PostMapping("")
    public ResponseEntity<Manipulation> createManipulation(@RequestBody Manipulation manipulation) {
        try {
            return new ResponseEntity<>(iManipulationRepository.save(manipulation), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Save or update a manipulation
     *
     * @param id manipulation object id
     * @param manipulation manipulation object
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Manipulation> updateManipulation(@PathVariable("id") Long id,
                                                           @RequestBody Manipulation manipulation) {
        Optional<Manipulation> manipulationData = iManipulationRepository.findById(id);

        if (manipulationData.isPresent()) {
            Manipulation _manipulation = manipulationData.get();
            _manipulation.setManipulationType(manipulation.getManipulationType());
            _manipulation.setManipulationCode(manipulation.getManipulationCode());
            _manipulation.setNhifPriceUnder18(manipulation.getNhifPriceUnder18());
            _manipulation.setNhifPriceOver18(manipulation.getNhifPriceOver18());
            _manipulation.setPatientPriceUnder18(manipulation.getPatientPriceUnder18());
            _manipulation.setPatientPriceOver18(manipulation.getPatientPriceOver18());
            return new ResponseEntity<>(iManipulationRepository.save(_manipulation), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a manipulation
     *
     * @param id manipulation object id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteManipulation(@PathVariable("id") Long id) {
        try {
            Optional<Manipulation> manipulationData = iManipulationRepository.findById(id);

            if (manipulationData.isPresent()) {
                Manipulation manipulation = manipulationData.get();
            }
            iManipulationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}