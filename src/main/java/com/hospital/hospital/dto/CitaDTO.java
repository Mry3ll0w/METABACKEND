package com.hospital.hospital.dto;
import java.util.Date;
import com.hospital.hospital.model.Medico;
import com.hospital.hospital.model.Paciente;

public record CitaDTO(Date fechaHora,
                      String motivoCita,
                      Medico medico,
                      Paciente paciente) {
}
