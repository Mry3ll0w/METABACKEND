package com.hospital.hospital.controller;

import com.hospital.hospital.dto.UsuarioDTO;
import com.hospital.hospital.model.Usuario;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hospital.hospital.service.UsuarioService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/create")
    public String createUser(@RequestBody Usuario user) {
        usuarioService.createUsuario(user);
        return "Creado";
    }

    @GetMapping
    public Optional<List<UsuarioDTO>> getAllUsers() {

        return usuarioService.getAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<UsuarioDTO> getOneUserByUserName(@PathVariable String name) {
        Optional<UsuarioDTO> user = usuarioService.getOneUserByUsername(name);

        // Manejo de respuesta en caso de que no se encuentre el usuario
        return user.map(ResponseEntity::ok) // Si el usuario existe, devolver 200 OK con el usuario
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no existe, devolver 404 Not Found
    }

    @PatchMapping("/{name}")
    public ResponseEntity<String> updateUserProperties(@PathVariable String name, @RequestBody Map<String, Object> updates) {

        boolean bIsUpdated = usuarioService.updateUserProperties(name, updates);

        if (bIsUpdated) {
            return ResponseEntity.ok("Usuario actualizado correctamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
