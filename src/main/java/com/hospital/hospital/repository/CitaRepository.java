package com.hospital.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.hospital.model.Cita;

import java.util.Optional;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    Cita save(Cita c);
    Optional<Cita> findByatributo11(Integer atributo11);


}
