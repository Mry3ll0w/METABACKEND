package com.hospital.hospital.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue
    private long id;
    private String valoracionEspecialista, enfermedad;

    @OneToOne(mappedBy = "diagnostico")
    private Cita cita;

}
