package com.growza_prueba.growzap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Detalles_Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_detalle_pedido;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private int cantidad;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private double precio_unitario;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    //* Constructores
    public Detalles_Pedidos() {
    }

    public Detalles_Pedidos(Long id_detalle_pedido, int cantidad, double precio_unitario, Pedidos pedido, Productos producto) {
        this.id_detalle_pedido = id_detalle_pedido;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.pedido = pedido;
        this.producto = producto;
    }

    //*  Getter y Setter
    public Long getId_detalle_pedido() {
        return id_detalle_pedido;
    }

    public void setId_detalle_pedido(Long id_detalle_pedido) {
        this.id_detalle_pedido = id_detalle_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
}
