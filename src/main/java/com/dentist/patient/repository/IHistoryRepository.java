package com.dentist.patient.repository;

import com.dentist.patient.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHistoryRepository extends JpaRepository<History, Long> {
    List<History> findByPatientId(Long patient);
}