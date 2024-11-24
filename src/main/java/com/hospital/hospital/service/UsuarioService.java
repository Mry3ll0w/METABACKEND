package com.hospital.hospital.service;

import com.hospital.hospital.dto.UsuarioDTO;
import com.hospital.hospital.mappers.UsuarioMapper;
import com.hospital.hospital.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.hospital.repository.UsuarioRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        //Si esta vacio devolvera null al no tener nada que recorrer --> Preguntar
        return u.map(usuario -> mapper.usuarioToUsuarioDTO(usuario));

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
                        break;//Si se introduce un campo no valido no se hace nada, mayor compatibilidad entre usuario, Medico y Paciente
                }
            });

            // Guardar usuario actualizado en la base de datos
            usuarioRepository.save(user);
            return true;
        }

        return false; // Usuario no encontrado
    }

    //!! Interfaces de Servicios TEMPLATE METHODS, AUTOWIRED

}




















