package com.ejemplo.proyecto.service;

import java.util.List;

import com.ejemplo.proyecto.entity.Usuario1;

public interface UsuarioService {
    public List<Usuario1> CargarUsuario();
    public Usuario1 login(String username,String constraseña);
}
