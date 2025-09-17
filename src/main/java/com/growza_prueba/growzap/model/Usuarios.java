package com.growza_prueba.growzap.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Usuarios {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private String nombre;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private String apellido;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    @Email
    private String correo;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private String contraseña;

    @PastOrPresent(message = "La fecha no puede ser futura")
    @Column(nullable = false)
    private LocalDate fecha_registro;

    //! Relaciones
    //* Un usuario tiene un carrito
    @OneToOne(mappedBy = "usuarios", cascade = CascadeType.ALL)
    private Carrito carrito;

    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
    private List<Pedidos> pedidos;

    //* Constructores de Usuarios
    public Usuarios() {
    }

    public Usuarios(Long id_usuario, String nombre, String apellido, String correo, String contraseña, LocalDate fecha_registro) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fecha_registro = fecha_registro;
    }

    //* Getters y Setters
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

}
