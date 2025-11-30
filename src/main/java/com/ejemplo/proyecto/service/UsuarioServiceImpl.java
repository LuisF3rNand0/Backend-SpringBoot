package com.ejemplo.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ejemplo.proyecto.entity.Usuario1;
import com.ejemplo.proyecto.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario1> CargarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario1 login(String usuUsername, String usuPassword) {
        // 1️⃣ Buscar usuario por username
        Usuario1 usuario = usuarioRepository.findByUsuUsername(usuUsername)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 2️⃣ Limpiar espacios
        if (!usuario.getUsu_password().trim().equals(usuPassword.trim())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return usuario;
    }

}
