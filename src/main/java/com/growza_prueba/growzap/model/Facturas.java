package com.growza_prueba.growzap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class Facturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    @PastOrPresent(message = "La fecha no puede ser futura")
    @Column(nullable = false)
    private LocalDate fecha_emision;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private double numero_factura;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pagos pago;

    //* Constructores
    public Facturas() {
    }

    public Facturas(Long id_factura, LocalDate fecha_emision, double numero_factura, Pedidos pedido, Pagos pago) {
        this.id_factura = id_factura;
        this.fecha_emision = fecha_emision;
        this.numero_factura = numero_factura;
        this.pedido = pedido;
        this.pago = pago;
    }

    //* Getter y Setter
    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public LocalDate getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public double getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(double numero_factura) {
        this.numero_factura = numero_factura;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public Pagos getPago() {
        return pago;
    }

    public void setPago(Pagos pago) {
        this.pago = pago;
    }
}
