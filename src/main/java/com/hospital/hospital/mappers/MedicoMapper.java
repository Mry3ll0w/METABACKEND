package com.hospital.hospital.mappers;

import com.hospital.hospital.dto.MedicoDTO;
import com.hospital.hospital.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
@Mapper
public interface MedicoMapper {

    //Inicializamos la instancia del mapper, similar al autowired
    MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

//    @Mapping(source = "nombre", target = "nombre")
//    @Mapping(source = "apellidos", target = "apellidos")
//    @Mapping(source = "usuario", target = "usuario")
//    @Mapping(source = "numColegiado", target = "numColegiado")
    MedicoDTO toMedicoDTO(Medico medico);

//    @Mapping(source = "nombre", target = "nombre")
//    @Mapping(source = "apellidos", target = "apellidos")
//    @Mapping(source = "usuario", target = "usuario")
//    @Mapping(source = "numColegiado", target = "numColegiado")
    List<MedicoDTO> toListMedicoDTO(List<Medico> lMedicos);

}
