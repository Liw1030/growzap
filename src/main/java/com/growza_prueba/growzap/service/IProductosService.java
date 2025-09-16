package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Productos;

import java.util.List;
import java.util.Optional;

public interface IProductosService {

    List<Productos> obtenerProductos();
    Optional<Productos> obtenerPorId (Long id);
    void guardarProducto (Productos producto);
    void editarProducto (Long id , Productos producto);
    void eliminarProducto (Long id);
}
