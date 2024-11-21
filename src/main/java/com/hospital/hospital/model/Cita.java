package com.hospital.hospital.model;

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
    private Date fechaHora;

    @Column(name = "motivoCita")
    private String motivoCita;

    @Column(name = "atributo11")
    private Integer atributo11;

    //Relacion directa 1 : 1
    @OneToOne
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










