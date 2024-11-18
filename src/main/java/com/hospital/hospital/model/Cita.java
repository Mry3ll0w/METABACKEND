package com.hospital.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue
    private long id;
    private Date fechaHora;
    private String motivoCita;
    private Integer atributo11;

    //Relacion directa 1 : 1
    @OneToOne
    @JoinColumn(name = "diagnosticoID")
    private Diagnostico diagnostico;

    //Relacion Inversa 1 : 1
    private Medico medico;

    // Relacion Inversa 1 : 1
    private Paciente paciente;

    Cita(){

    }


}










