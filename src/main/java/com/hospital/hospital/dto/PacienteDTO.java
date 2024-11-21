package com.hospital.hospital.dto;

public record PacienteDTO(
        String nombre,
        String apellidos,
        String usuario,
        String NSS,
        String numTarjeta
        ) {
}
