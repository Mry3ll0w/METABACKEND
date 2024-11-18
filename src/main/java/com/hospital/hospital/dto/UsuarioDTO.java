package com.hospital.hospital.dto;

import com.hospital.hospital.model.Usuario;
import lombok.Getter;
import lombok.Setter;


public record UsuarioDTO(String nombre, String apellidos, String usuario) {

}
