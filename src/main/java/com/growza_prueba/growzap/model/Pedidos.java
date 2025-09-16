package com.growza_prueba.growzap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    @PastOrPresent(message = "La fecha no puede ser futura")
    @Column(nullable = false)
    private LocalDate fecha_pedido;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private double total;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuarios usuario;

    //* Constructores
    public Pedidos() {
    }

    public Pedidos(Long id_pedido, LocalDate fecha_pedido, double total, String estado, Usuarios usuario) {
        this.id_pedido = id_pedido;
        this.fecha_pedido = fecha_pedido;
        this.total = total;
        this.estado = estado;
        this.usuario = usuario;
    }

    //* Getters y Setters

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public LocalDate getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(LocalDate fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuarios getUsuarios() {
        return usuario;
    }

    public void setUsuarios(Usuarios usuario) {
        this.usuario = usuario;
    }
}
