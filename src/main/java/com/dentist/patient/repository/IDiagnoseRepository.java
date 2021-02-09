package com.dentist.patient.repository;

import com.dentist.patient.model.Diagnose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiagnoseRepository extends JpaRepository<Diagnose, Long> {
}
