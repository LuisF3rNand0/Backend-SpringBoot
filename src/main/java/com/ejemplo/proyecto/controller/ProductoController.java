package com.ejemplo.proyecto.controller;

import com.ejemplo.proyecto.entity.Producto1;
import com.ejemplo.proyecto.repository.ProductoRepository;
import com.ejemplo.proyecto.service.ProductoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoServiceImpl productoServiceImpl;


    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo, ProductoServiceImpl productoServiceImpl) {
        this.repo = repo;
        this.productoServiceImpl = productoServiceImpl;
    }

    @GetMapping
    public List<Producto1> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Producto1 guardar(@RequestBody Producto1 producto) {
        return repo.save(producto);
    }

    @PutMapping("/{id}")
    public Producto1 actualizar(@PathVariable Integer id, @RequestBody Producto1 producto) {
        producto.setId(id);
        return repo.save(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
    }

    @GetMapping("/buscar")
    public List<Producto1> buscarProductos(@RequestParam String q) {
        return productoServiceImpl.buscarPorNombreODescripcion(q);
    }

}


