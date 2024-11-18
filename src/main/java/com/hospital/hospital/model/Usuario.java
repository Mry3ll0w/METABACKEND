package com.hospital.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@PersistenceContext
@Entity
@Getter
@Setter
@Table(name = "Usuarios")
public class Usuario {
    public Usuario(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;

}
