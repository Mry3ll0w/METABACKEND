package com.hospital.hospital.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "valoracion_especialista")
    private String valoracionEspecialista;

    @Column(name = "enfermedad")
    private String enfermedad;

    // Asumimos que puede existir diagnostico sin cita
    @OneToOne(mappedBy = "diagnostico")
    @Nullable
    private Cita cita;

}
