package com.ejemplo.proyecto.service;

import com.ejemplo.proyecto.entity.Producto1;
import com.ejemplo.proyecto.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService { // <-- debe ser ProductoService

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto1> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto1 buscarPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto1> buscarPorNombreODescripcion(String texto) {
        return productoRepository.findByNombreContainingIgnoreCaseOrDescripcionContainingIgnoreCase(texto, texto);
    }
}
