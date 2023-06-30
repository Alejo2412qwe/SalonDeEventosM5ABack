/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.controller;

import com.m5a.salon.model.entity.ImagenesProductos;
import com.m5a.salon.service.ImagenesProductosService;
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
@RequestMapping("/imgproductos")
public class ImgProductosController {

    @Autowired
    public ImagenesProductosService imagenesProductosService;

    @GetMapping("/listar")
    public ResponseEntity<List<ImagenesProductos>> listarImg() {
        return new ResponseEntity<>(imagenesProductosService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ImagenesProductos> crearImg(@RequestBody ImagenesProductos img) {
        return new ResponseEntity<>(imagenesProductosService.save(img), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ImagenesProductos> actualizarImg(@PathVariable Integer id, @RequestBody ImagenesProductos img) {
        ImagenesProductos imagen = imagenesProductosService.findById(id);
        if (imagen != null) {
            try {

                imagen.setImgProdId(img.getImgProdId());
                imagen.setImgProdNombre(img.getImgProdNombre());
                imagen.setImgProdUrl(img.getImgProdUrl());
                imagen.setProductoServicio(img.getProductoServicio());

                return new ResponseEntity<>(imagenesProductosService.save(imagen), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ImagenesProductos> elimiarPersona(@PathVariable Integer id) {
        imagenesProductosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
