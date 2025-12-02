package com.ejemplo.proyecto.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.proyecto.entity.Ordenes;
import com.ejemplo.proyecto.service.OrdenesServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ordenes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class OrdenesController {

    private final OrdenesServiceImpl ordenesService;

    @PostMapping("/crear")
    public ResponseEntity<Ordenes> crearOrden(@RequestBody Map<String, Object>data ){
        Ordenes orden = ordenesService.crearOrden(data);
        return ResponseEntity.ok(orden);
    }
}
