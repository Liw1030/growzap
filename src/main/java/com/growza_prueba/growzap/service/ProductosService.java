package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Productos;
import com.growza_prueba.growzap.repository.IProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService implements IProductosService{
    private IProductosRepository productosRepository;
    @Autowired
    public ProductosService(IProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }


    @Override
    public List<Productos> obtenerProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Optional<Productos> obtenerPorId(Long id) {
        return productosRepository.findById(id);
    }

    @Override
    public void guardarProducto(Productos producto) {
        productosRepository.save(producto);
    }

    @Override
    public void editarProducto(Long id, Productos producto) {
        Optional<Productos> productoExiste = productosRepository.findById(id);
        if (productoExiste.isPresent()){
            Productos editarProducto = productoExiste.get();
            editarProducto.setNombre_producto(producto.getNombre_producto());
            editarProducto.setDescripcion(producto.getDescripcion());
            editarProducto.setPrecio(producto.getPrecio());
            editarProducto.setStock(producto.getStock());
            productosRepository.save(editarProducto);
        }else {
            throw new RuntimeException("El Producto no fue encontrado.");
        }
    }

    @Override
    public void eliminarProducto(Long id) {
        Optional<Productos> productoExiste = productosRepository.findById(id);
        if (productoExiste.isPresent()){
            Productos eliminarProducto = productoExiste.get();
            productosRepository.delete(eliminarProducto);
        }else {
            throw new RuntimeException("El Producto no fue encontrado.");
        }
    }
}
