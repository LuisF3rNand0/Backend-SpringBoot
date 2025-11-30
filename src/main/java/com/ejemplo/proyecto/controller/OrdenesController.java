package com.ejemplo.proyecto.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.proyecto.entity.Ordenes;
import com.ejemplo.proyecto.service.OrdenesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ordenes")
@RequiredArgsConstructor
public class OrdenesController {

    private final OrdenesService ordenesService;

    @PostMapping("/crear")
    public ResponseEntity<Ordenes> crearOrden(@RequestBody Map<String, Object>data ){
        Ordenes orden = ordenesService.crearOrden(data);
        return ResponseEntity.ok(orden);
    }
}
