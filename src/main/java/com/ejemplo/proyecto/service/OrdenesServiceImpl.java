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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenesServiceImpl implements OrdenesService{

    private final OrdenesRepository ordenesRepository;
    private final DetallesRepository detallesRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;
    
    
    @Override
    public Ordenes crearOrden(Map<String, Object> data) {
Integer usuarioId = (Integer) ((Number) data.get("usuarioId")).intValue();
        @SuppressWarnings("unchecked")
        List<Map<String,Object>> detallesList=(List<Map<String,Object>>) data.get("detalles");

        Usuario1 usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Ordenes orden = new Ordenes();
        orden.setUsuario(usuario);
        orden.setOrden_fechacreacion(LocalDate.now());
        orden.setOrden_num("ORD-"+(int)(Math.random() * 100000));
        orden.setOrden_total(0.0);


        Ordenes ordenGuardada = ordenesRepository.save(orden);

        double totalgeneral=0.0;

        for (Map<String, Object> item:detallesList){

            Integer productoId = (Integer) item.get("productoId");
int cantidad = ((Number) item.get("cantidad")).intValue();
            Producto1 producto = productoRepository.findById(productoId).orElseThrow(() ->new RuntimeException("Producto no encontrado"));

            double subtotal = producto.getPrecio() * cantidad;
            totalgeneral += subtotal;

            Detalles detalle = new  Detalles();

            detalle.setOrdenes(ordenGuardada);
            detalle.setProducto(producto);
            detalle.setDetalleo_precio(producto.getPrecio());
            detalle.setDetalleo_total(subtotal);
            detalle.setDetalleo_nom(producto.getNombre());
detalle.setDetalleo_cantidad((double) cantidad);

            detallesRepository.save(detalle);
        }

        ordenGuardada.setOrden_total(totalgeneral);
        return ordenesRepository.save(ordenGuardada);
        

    }

    
}
