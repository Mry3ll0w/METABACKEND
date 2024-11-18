package com.hospital.hospital.model;

import jakarta.persistence.Entity;
import lombok.Setter;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Setter
public class Paciente extends Usuario{

    private String NSS, numTarjeta, telefono, direccion;

    // Relacion Directa 1 : N
    private List<Cita> citas;

    // Relacion Directa N : N
    private List<Medico> medicos;

}
