package model;

import jakarta.persistence.Entity;
import lombok.Setter;
import lombok.Getter;
@Entity
@Getter
@Setter
public class Paciente extends Usuario{

    private String NSS, numTarjeta, telefono, direccion;

}
