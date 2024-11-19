package com.hospital.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Medico extends Usuario {
    private String numColegiado;

    // Relacion Directa 1 : N
    @OneToMany(mappedBy = "medico") // Ya que en la clase Citas esta el elemento medico que es el otro extremo de la relacion
    private List<Cita> citas;

    // Relacion Directa N : N
    @ManyToMany
    @JoinTable(
            name = "medico_paciente", // Nombre de la tabla intermedia para relaciones n:n
            joinColumns = @JoinColumn(name = "medico_id"), // FK para Medico
            inverseJoinColumns = @JoinColumn(name = "paciente_id") // FK para Paciente
    )
    private List<Paciente> pacientes;

}
