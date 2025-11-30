package com.ejemplo.proyecto.service;

import com.ejemplo.proyecto.entity.Producto1;
import com.ejemplo.proyecto.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService {

    private final ProductoRepository productoRepository;

    // Lista en memoria para simular el carrito
    private final List<Producto1> carrito = new ArrayList<>();

    public CarritoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto1> ObtenerCarrito() {
        return carrito;
    }

    public List<Producto1> agregarProducto(Integer productoId) {
        Producto1 p = productoRepository.findById(productoId).orElse(null);
        if (p != null) {
            carrito.add(p);
        }
        return carrito;
    }

    public List<Producto1> eliminarPorIndex(int index) {
        if (index >= 0 && index < carrito.size()) {
            carrito.remove(index);
        }
        return carrito;
    }

    // Limpiar todo el carrito
    public List<Producto1> limpiar() {
        carrito.clear();
        return carrito;
    }

    // Calcular total
    public Double total() {
        return carrito.stream()
                .mapToDouble(Producto1::getPrecio)
                .sum();
    }
}
