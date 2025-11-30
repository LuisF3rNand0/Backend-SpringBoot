package com.ejemplo.proyecto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="detalles")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detalleo_id;

    private String detalleo_nom;
    @Column(name="detalleo_cantidad", nullable = false)
    private Double detalleo_cantidad;
    @Column(name="detalleo_precio", nullable = false)
    private Double detalleo_precio;
    @Column(name="detalleo_total", nullable = false)

    private Double detalleo_total;

    @ManyToOne
    @JoinColumn(name = "orden_orden_id")
    private Ordenes ordenes;

    @ManyToOne
    @JoinColumn(name = "producto_prod_id")
    private Producto1 producto;



    
}
