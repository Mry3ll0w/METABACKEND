package com.hospital.hospital.repository;

import com.hospital.hospital.model.Cita;
import com.hospital.hospital.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {

    Optional<Diagnostico> findBycita(Cita c);
    Optional<List<Diagnostico>> findByenfermedad(String enfermedad);
}
