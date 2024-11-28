package com.hospital.hospital.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "citas")
public class Cita {// !Tipos JPA Herencia (3)
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String fechaHora;

    @Column(name = "motivoCita")
    private String motivoCita;

    @Column(name = "atribute11")
    private Integer atributo11;

    // Puede existir una cita sin diagnostico aun, pero tiene que tener un medico y un paciente

    //Relacion directa 1 : 1
    @OneToOne
    @Nullable
    @JoinColumn(name = "diagnosticoID")
    private Diagnostico diagnostico;

    //Relacion Inversa N : 1
    @ManyToOne
    @JoinColumn(name = "medicoID")
    private Medico medico;

    // Relacion Inversa N : 1
    @ManyToOne
    @JoinColumn(name = "pacienteID")
    private Paciente paciente;

    Cita(){

    }


}










