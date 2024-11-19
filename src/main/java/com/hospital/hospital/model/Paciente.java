package com.hospital.hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Setter;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Setter
public class Paciente extends Usuario{

    private String NSS, numTarjeta, telefono, direccion;

    // Relacion Directa 1 : N
    @OneToMany(mappedBy = "paciente", orphanRemoval = true)
    private List<Cita> citas;

    // Relacion  N : N
    @ManyToMany(mappedBy = "pacientes")
    private List<Medico> medicos;

}
