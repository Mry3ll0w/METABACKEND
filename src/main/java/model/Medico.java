package model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Medico extends Usuario {
    private String numColegiado;

}
