package com.hospital.hospital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@PersistenceContext // Utilidad ??
@Getter
@Setter // DATA y no getters, setters
@Entity(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "usertype",
        discriminatorType = DiscriminatorType.INTEGER
)// Decimos si es Medico (0) o Paciente (1) segun el valor de esta
public class Usuario implements UserDetails {// Para temas de seguridad
    public Usuario(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //Sequency (control de secuencia por parte de Java)
    @Column(name = "id")
    private Long id;// Usar @Column

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "usuario", unique = true)
    private String usuario;

    @Column(name = "clave")
    private String clave;

    @Column(name = "usertype", nullable = false, insertable = false, updatable = false)
    private Integer usertype;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return getClave();
    }

    @Override
    public String getUsername() {
        return getUsuario();
    }


}
