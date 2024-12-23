package com.hospital.hospital.repository;

import com.hospital.hospital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    Paciente save(Paciente p);
    Optional<Paciente> findByNSS(String nss);
    Optional<Paciente> findByNombre(String nombre);

}
