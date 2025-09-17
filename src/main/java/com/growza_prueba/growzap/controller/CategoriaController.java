package com.growza_prueba.growzap.controller;

import com.growza_prueba.growzap.model.Carrito;
import com.growza_prueba.growzap.model.Categorias;
import com.growza_prueba.growzap.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/growza/categorias")
public class CategoriaController {

        private CategoriasService categoriasService;
        @Autowired
        public CategoriaController(CategoriasService carritoService) {
            this.categoriasService = carritoService;
        }

        @GetMapping
        public List<Categorias> listaCategorias(){
            return categoriasService.obtenerCategorias();
        }

        @GetMapping("/{id}")
        public Object ListaCategoriasID (@PathVariable Long id){
            return  categoriasService.obtenerPorId(id);
        }

        @PostMapping("/crear")
        public ResponseEntity<String> guardarCategoria (@RequestBody Categorias categorias){
            categoriasService.guardarCategorias(categorias);
            return ResponseEntity.ok("categorias Guardada con exito []~(￣▽￣)~*");
        }

        @PutMapping ("/editar/{id}")
        public ResponseEntity <String> editarCarrito (@PathVariable Long id, @RequestBody Categorias categorias){
            categoriasService.editarCategoria(id,categorias);
            return ResponseEntity.ok("Categoria editado con exito []~(￣▽￣)~*");
        }

        @DeleteMapping ("/eliminar/{id}")
        public ResponseEntity <String> eliminarCarrito (@PathVariable Long id ){
            categoriasService.eliminarCategoria(id);
            return ResponseEntity.ok("Categoria eliminado con exito ");
        }
}
