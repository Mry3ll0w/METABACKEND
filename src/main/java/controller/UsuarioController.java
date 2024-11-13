package controller;

import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UsuarioService;

@RestController
@RequestMapping("/user/create")
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario user) {

        return ResponseEntity.ok(usuarioService.saveUsuario(user));
    }
}
