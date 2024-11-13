package com.hospital.hospital.service;

import com.hospital.hospital.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.hospital.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(Usuario u){
        return usuarioRepository.save(u);
    }

    // Add other methods as needed
}
