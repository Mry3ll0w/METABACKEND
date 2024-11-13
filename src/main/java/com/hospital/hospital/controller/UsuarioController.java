package com.hospital.hospital.controller;

import com.hospital.hospital.model.Usuario;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hospital.hospital.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/create")
    public String createUser(@RequestBody Usuario user) {
        return "HOLA";
    }

    @GetMapping
    public Response test(@RequestBody Usuario user) {
        return new Response(Response.SC_ACCEPTED);
    }
}
