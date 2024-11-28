package com.hospital.hospital.mappers;


import com.hospital.hospital.dto.CitaDTO;
import com.hospital.hospital.model.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface CitaMapper {

    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);

    CitaDTO toCitaDTO(Cita cita);

    List<CitaDTO> toListCitaDTO(List<Cita> lCitas);

}
