package com.ejemplo.proyecto.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ejemplo.proyecto.entity.Usuario1;
import com.ejemplo.proyecto.service.UsuarioService;
import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> datos) {
        
        String username = datos.get("usuUsername");
        String password = datos.get("usu_password");
        try {
        Usuario1 user = usuarioService.login(username, password);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }
}
