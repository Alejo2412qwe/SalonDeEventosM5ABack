/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.controller;

import com.m5a.salon.model.entity.ProductoServicio;
import com.m5a.salon.service.productoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LaptopSA
 */
@RestController
@RequestMapping("/productoServicio")
public class productoController {

    @Autowired
    productoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<ProductoServicio>> listarProductos() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ProductoServicio> crearProductos(@RequestBody ProductoServicio ps) {
        return new ResponseEntity<>(service.save(ps), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductoServicio> actualizarProductos(@PathVariable Integer id, @RequestBody ProductoServicio ps) {
        ProductoServicio producto = service.findById(id);
        if (producto != null) {
            try {

                producto.setIdProductoServicio(ps.getIdProductoServicio());
                producto.setNombre(ps.getNombre());
                producto.setPrecio(ps.getPrecio());
                producto.setEstado(ps.getEstado());
                producto.setDescripcion(ps.getDescripcion());
                producto.setCategoria(ps.getCategoria());
                producto.setTipo(ps.getTipo());

                return new ResponseEntity<>(service.save(producto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ProductoServicio> elimiarProductos(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
