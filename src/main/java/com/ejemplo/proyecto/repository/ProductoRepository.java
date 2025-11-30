package com.ejemplo.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ejemplo.proyecto.entity.Producto1;

public interface ProductoRepository extends JpaRepository<Producto1, Integer> {
    List<Producto1> findByNombreContainingIgnoreCaseOrDescripcionContainingIgnoreCase(
        String nombre,
        String descripcion
    );

}
