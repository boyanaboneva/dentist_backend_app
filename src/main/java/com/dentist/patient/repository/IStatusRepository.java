package com.dentist.patient.repository;

import com.dentist.patient.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStatusRepository extends JpaRepository<Status, Long> {
    List<Status> findByPatientId(Long patient);
}
