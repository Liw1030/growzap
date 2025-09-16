package com.growza_prueba.growzap.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;

    //* Relaciones

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @JsonManagedReference
    private Usuarios usuarios;

    //* Constructores
    public Carrito() {
    }

    public Carrito(Long id_carrito, Usuarios usuarios) {
        this.id_carrito = id_carrito;
        this.usuarios = usuarios;
    }

    //* Getters y Setters

    public Long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Long id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
