package com.hospital.hospital.service;

import com.hospital.hospital.dto.UsuarioDTO;
import com.hospital.hospital.mappers.UsuarioMapper;
import com.hospital.hospital.model.Usuario;
import org.hibernate.sql.model.jdbc.OptionalTableUpdateOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.hospital.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Llamamos al mapper para usarlo
    private UsuarioMapper mapper = UsuarioMapper.INSTANCE;

    public void createUsuario(Usuario u){

        usuarioRepository.save(u);
    }

    public Optional<List<UsuarioDTO>> getAll(){

        //Obtenemos todos los Usuarios
        return Optional.of(mapper.usuariosToUsuarioDTOs(usuarioRepository.findAll()));
    }

    public Optional<UsuarioDTO> getOneUserByName(String name){
        Optional<Usuario> u = usuarioRepository.findBynombre(name);
        if(u.isPresent()){
            Usuario us = u.get();
            return Optional.of(new UsuarioDTO(us.getNombre(),us.getApellidos(),us.getUsuario()));
        }else{
            return Optional.empty();
        }

    }

    public boolean updateUserProperties(String name, Map<String, Object> updates) {
        Optional<Usuario> optUser = usuarioRepository.findBynombre(name);

        if (optUser.isPresent()) {
            Usuario user = optUser.get();// Al estar presente lo "sacamos" (de opt a Usuario)

            // Aplicar las actualizaciones
            updates.forEach((key, value) -> {
                switch (key) {
                    case "nombre":
                        user.setNombre((String) value);//Cast a String p
                        break;
                    case "apellidos":
                        user.setApellidos((String) value);
                        break;
                    case "usuario":
                        user.setUsuario((String) value);
                        break;
                    case "clave":
                        user.setClave((String) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Campo no válido: " + key);
                }
            });

            // Guardar usuario actualizado en la base de datos
            usuarioRepository.save(user);
            return true;
        }

        return false; // Usuario no encontrado
    }


}




















