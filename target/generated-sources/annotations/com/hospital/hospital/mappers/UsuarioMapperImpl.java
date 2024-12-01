package com.hospital.hospital.mappers;

import com.hospital.hospital.dto.UsuarioDTO;
import com.hospital.hospital.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:28:48+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Ubuntu)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        String nombre = null;
        String apellidos = null;
        String usuario1 = null;

        nombre = usuario.getNombre();
        apellidos = usuario.getApellidos();
        usuario1 = usuario.getUsuario();

        UsuarioDTO usuarioDTO = new UsuarioDTO( nombre, apellidos, usuario1 );

        return usuarioDTO;
    }

    @Override
    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNombre( usuarioDTO.nombre() );
        usuario.setApellidos( usuarioDTO.apellidos() );
        usuario.setUsuario( usuarioDTO.usuario() );

        return usuario;
    }

    @Override
    public List<UsuarioDTO> usuariosToUsuarioDTOs(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( usuarioToUsuarioDTO( usuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> usuarioDTOsToUsuarios(List<UsuarioDTO> usuarioDTOs) {
        if ( usuarioDTOs == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( usuarioDTOs.size() );
        for ( UsuarioDTO usuarioDTO : usuarioDTOs ) {
            list.add( usuarioDTOToUsuario( usuarioDTO ) );
        }

        return list;
    }
}
