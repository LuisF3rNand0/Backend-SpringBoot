package com.ejemplo.proyecto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ejemplo.proyecto.entity.Ordenes;


public interface OrdenesRepository  extends JpaRepository<Ordenes, Integer>{
}
