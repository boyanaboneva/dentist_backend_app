package com.dentist.patient.repository;

import com.dentist.patient.model.Manipulation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IManipulationRepository extends JpaRepository<Manipulation, Long> {
    List<Manipulation> findByManipulationCode(Long manipulationCode);
}
