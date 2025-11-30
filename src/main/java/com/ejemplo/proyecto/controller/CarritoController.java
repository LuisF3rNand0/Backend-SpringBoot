package com.ejemplo.proyecto.controller;

import com.ejemplo.proyecto.entity.Producto1;
import com.ejemplo.proyecto.service.CarritoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/carrito")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") // Ajusta según tu Angular
public class CarritoController {

    private final CarritoService carritoService;
    // Listar productos en el carrito


    @GetMapping
    public List<Producto1> obtenerCarrito(){
        return carritoService.ObtenerCarrito();
    }

    @PostMapping("/agregar/{id}")
    public List<Producto1> agregar(@PathVariable Integer id){
        return carritoService.agregarProducto(id);
    }

    @DeleteMapping("/eliminar/{index}")
    public List<Producto1> eliminar(@PathVariable int index){
        return carritoService.eliminarPorIndex(index);
    }

    @DeleteMapping("/limpiar")
    public List<Producto1> limpiar(){
        return carritoService.limpiar();
    }

    @GetMapping("/total")
    public Double total(){
        return carritoService.total();
    }
}
