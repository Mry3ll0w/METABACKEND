package com.hospital.hospital.mappers;

import com.hospital.hospital.dto.UsuarioDTO;
import com.hospital.hospital.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {

    //Inicializamos la instancia del mapper, similar al autowired
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    // Pasar de Usuario a UsuarioDTO
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    // Pasar de UsuarioDTO a Usuario
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);

    // Listas de Usuario a listas de UsuarioDTO
    List<UsuarioDTO> usuariosToUsuarioDTOs(List<Usuario> usuarios);

    // Listas de UsuarioDTO a listas de Usuario
    List<Usuario> usuarioDTOsToUsuarios(List<UsuarioDTO> usuarioDTOs);
}