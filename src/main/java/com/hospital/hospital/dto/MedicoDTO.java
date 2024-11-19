package com.hospital.hospital.dto;

import com.hospital.hospital.model.Cita;
import com.hospital.hospital.model.Paciente;

import java.util.List;

public record MedicoDTO(List<Cita> citas, List<Paciente> pacientes) {
}
