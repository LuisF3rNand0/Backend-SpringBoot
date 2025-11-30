package com.ejemplo.proyecto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="usuarios")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usu_id;

    @Column(name="usu_nom", nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 40,message = "El nombre debe tener 2-40 caracteres")
    private String usu_nom;

    @Column(name="usu_username", nullable = false)
    private String usuUsername;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    @Column(name="usu_email", nullable = false)
    private String usu_email;


    private String usu_direccion;

    private String usu_telefono;

    @Column(name="usu_tipo", nullable = false)
    private String usu_tipo;

    @Column(name="usu_password", nullable = false)
    private String usu_password;
    
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Ordenes> ordenes;
}
