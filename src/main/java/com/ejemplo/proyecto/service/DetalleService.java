package com.ejemplo.proyecto.service;

import java.util.List;

import com.ejemplo.proyecto.entity.Detalles;

public interface DetalleService {

    List<Detalles> obtenerDetallePorOrden (Integer ordenID);
}
