package com.hospital.hospital.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("0")
public class Medico extends Usuario {
    @Column(name = "numColegiado")
    private String numColegiado;

    // Relacion Directa 1 : N
    @Nullable
    @OneToMany(mappedBy = "medico") // Ya que en la clase Citas esta el elemento medico que es el otro extremo de la relacion
    private List<Cita> citas;

    // Relacion Directa N : N
    @ManyToMany //Un medico debe tener Pacientes
    @Nullable
    @JoinTable(
            name = "medico_paciente", // Nombre de la tabla intermedia para relaciones n:n
            joinColumns = @JoinColumn(name = "medicoID"), // FK para Medico
            inverseJoinColumns = @JoinColumn(name = "pacienteID") // FK para Paciente
    )
    private List<Paciente> pacientes;
    Medico(){
        this.setUsertype(0);
    }

}
