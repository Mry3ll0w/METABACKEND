package com.hospital.hospital.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Medico extends Usuario {
    private String numColegiado;

    // Relacion Directa N : 1
    private List<Cita> citas;

    // Relacion Directa N : N
    private List<Paciente> pacientes;

}
