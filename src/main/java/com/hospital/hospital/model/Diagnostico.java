package com.hospital.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "diagnosticos")
public class Diagnostico {
    @Id
    @GeneratedValue
    private long id;
    private String valoracionEspecialista, enfermedad;

    @OneToOne(mappedBy = "diagnostico")
    private Cita cita;

}
