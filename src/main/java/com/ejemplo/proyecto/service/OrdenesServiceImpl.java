package com.ejemplo.proyecto.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ejemplo.proyecto.entity.Detalles;
import com.ejemplo.proyecto.entity.Ordenes;
import com.ejemplo.proyecto.entity.Usuario1;
import com.ejemplo.proyecto.entity.Producto1;

import com.ejemplo.proyecto.repository.DetallesRepository;
import com.ejemplo.proyecto.repository.OrdenesRepository;
import com.ejemplo.proyecto.repository.ProductoRepository;
import com.ejemplo.proyecto.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenesServiceImpl implements OrdenesService{

    private final OrdenesRepository ordenesRepository;
    private final DetallesRepository detallesRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;
    
    
    @Override
    @Transactional
    public Ordenes crearOrden(Map<String, Object> data) {
        // -------------------------
        // 1. OBTENER USUARIO
        // -------------------------
        Integer usuarioId = ((Number) data.get("usuarioId")).intValue();

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> detallesList =
                (List<Map<String, Object>>) data.get("detalles");

        Usuario1 usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // -------------------------
        // 2. CREAR ORDEN
        // -------------------------
        Ordenes orden = new Ordenes();
        orden.setUsuario(usuario);
        orden.setOrden_fechacreacion(LocalDate.now());
        orden.setOrden_num("ORD-" + (int)(Math.random() * 100000));
        orden.setOrden_total(0.0);

        // Guardar orden primero (IMPORTANTE)
        Ordenes ordenGuardada = ordenesRepository.save(orden);

        double totalgeneral = 0.0;

        // -------------------------
        // 3. CREAR DETALLES
        // -------------------------
        for (Map<String, Object> item : detallesList) {

            // Puede venir como Integer o como Double según Angular
            Integer productoId = ((Number) item.get("productoId")).intValue();
            int cantidad = ((Number) item.get("cantidad")).intValue();

            Producto1 producto = productoRepository.findById(productoId)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            double subtotal = producto.getPrecio() * cantidad;
            totalgeneral += subtotal;


            int stockActual = Integer.parseInt(producto.getCantidad());

            if (stockActual < cantidad) {
                throw new RuntimeException("Stock insuficiente para: " + producto.getNombre());
            }

            int nuevoStock = stockActual - cantidad;
            producto.setCantidad(String.valueOf(nuevoStock));

            
            Detalles detalle = new Detalles();
            detalle.setOrdenes(ordenGuardada);
            detalle.setProducto(producto);

            detalle.setDetalleo_precio(producto.getPrecio());
            detalle.setDetalleo_total(subtotal);
            detalle.setDetalleo_nom(producto.getNombre());
            detalle.setDetalleo_cantidad((double) cantidad);

            detallesRepository.save(detalle);
        }

        // -------------------------
        // 4. ACTUALIZAR TOTAL
        // -------------------------
        ordenGuardada.setOrden_total(totalgeneral);
        return ordenesRepository.save(ordenGuardada);
    }

    
}
