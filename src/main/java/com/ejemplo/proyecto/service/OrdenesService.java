package com.ejemplo.proyecto.service;

import java.util.Map;
import com.ejemplo.proyecto.entity.Ordenes;
public interface OrdenesService {

    Ordenes crearOrden(Map<String,Object> data);
}
