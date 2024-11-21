package com.hospital.hospital.repository;

import com.hospital.hospital.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario save (Usuario u);
    Optional<Usuario> findBynombre(String name);
    // Usar Querys "a mano", JPQL
}


