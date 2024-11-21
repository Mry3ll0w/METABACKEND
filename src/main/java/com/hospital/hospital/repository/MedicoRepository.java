package com.hospital.hospital.repository;

import com.hospital.hospital.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Medico save(Medico m);
    Optional<Medico> findBynumColegiado(String numColegiado);
}
