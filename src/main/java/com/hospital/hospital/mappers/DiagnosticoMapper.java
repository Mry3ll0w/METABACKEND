package com.hospital.hospital.mappers;

import com.hospital.hospital.dto.DiagnosticoDTO;
import com.hospital.hospital.model.Diagnostico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;


@Mapper
public interface DiagnosticoMapper {

    DiagnosticoMapper INSTANCE = Mappers.getMapper(DiagnosticoMapper.class);

    DiagnosticoDTO toDiagnosticoDTO(Diagnostico d);

    List<DiagnosticoDTO> toListDiagnosticoDTO(List<Diagnostico> lDiags);

}
