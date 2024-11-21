package com.hospital.hospital.mappers;

import com.hospital.hospital.dto.PacienteDTO;
import com.hospital.hospital.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PacienteMapper {

    /// Instance
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    PacienteDTO toPacienteDTO(Paciente p);

    List<PacienteDTO> toListPacienteDTO(List<Paciente> p);

}
