package com.hospital.hospital.dto;

import com.hospital.hospital.model.Cita;
import com.hospital.hospital.model.Medico;

import java.util.List;

public record PacienteDTO(
        String NSS,
        String numTarjeta,
        List<Cita> citas,
        List<Medico> medicos) {
}
