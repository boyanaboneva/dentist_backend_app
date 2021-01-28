package com.dentist.patient.repository;

import com.dentist.patient.model.Diagnose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDiagnoseRepository extends JpaRepository<Diagnose, Long> {
//    List<Diagnose> findByName(String name);
}
