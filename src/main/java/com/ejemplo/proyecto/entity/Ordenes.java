package com.ejemplo.proyecto.entity;

import java.time.LocalDate;

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

@Table(name="ordenes")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orden_id;

    private String orden_num;

    @Column(name="orden_fechacreacion", nullable = false)
    private LocalDate orden_fechacreacion;

    @Column(name="orden_fecharecibida")
    private LocalDate orden_fecharecibida;

    private Double orden_total;

    @ManyToOne
    @JoinColumn(name = "usuario_usu_id")
    private Usuario1 usuario;
}

