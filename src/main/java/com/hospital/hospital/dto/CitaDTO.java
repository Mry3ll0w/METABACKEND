package com.hospital.hospital.dto;
import java.util.Date;
import com.hospital.hospital.model.Medico;


public record CitaDTO(Date fechaHora,
                      String motivoCita,
                      String numColegiadoMedico,
                      String nssPaciente
                      ) {
}
//Control de ciclos con multiples objetos, DTO
