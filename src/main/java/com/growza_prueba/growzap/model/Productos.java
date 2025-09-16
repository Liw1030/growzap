package com.growza_prueba.growzap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private String nombre_producto;

    private String descripcion;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private double precio;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private int stock;

    private String imagen_url;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categorias categoria;
}
