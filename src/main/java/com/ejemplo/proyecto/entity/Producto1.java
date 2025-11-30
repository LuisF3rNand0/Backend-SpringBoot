package com.ejemplo.proyecto.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="productos")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Producto1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prod_id")
    private Integer id;

    @Column(name="prod_nom")
    private String nombre;

    @Column(name="prod_descripcion")
    private String descripcion;

    @Column(name="prod_imagen")
    private String imagen;

    @Column(name="prod_precio")
    private Double precio;

    @Column(name="prod_cantidad")
    private String cantidad;

    @ManyToOne
    @JoinColumn(name="usuario_usu_id")
    @JsonIgnore
    private Usuario1 usuario;
}
