package com.hospital.hospital.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

//Recomendacion IntelliJ preguntar
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("1")
@Data
public class Paciente extends Usuario{
    @Column(name = "nss")
    private String NSS;

    @Column(name = "numTarjeta")
    private String numTarjeta;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    // Relacion Directa 1 : N
    @Nullable // Ya que no tiene pq tener citas
    @OneToMany(mappedBy = "paciente", orphanRemoval = true)
    private List<Cita> citas;

    // Relacion  N : N
    @Nullable
    @ManyToMany(mappedBy = "pacientes")// Debe tener pacientes
    private List<Medico> medicos;
    public Paciente(){
        this.setUsertype(1);
    }

}
