package com.ejemplo.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.proyecto.entity.Usuario1;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario1, Integer> {
    Optional<Usuario1> findByUsuUsername(String usuUsername);
}