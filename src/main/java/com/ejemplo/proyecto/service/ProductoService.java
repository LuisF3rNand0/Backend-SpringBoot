package com.ejemplo.proyecto.service;

import com.ejemplo.proyecto.entity.Producto1;
import java.util.List;

public interface ProductoService {
    List<Producto1> listar();
    Producto1 buscarPorId(Integer id);   
}
