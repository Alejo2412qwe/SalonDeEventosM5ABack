/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.controller;

import com.m5a.salon.model.entity.ImagenesSalones;
import com.m5a.salon.service.ImagenesSalonesService;
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
@RequestMapping("/imgsalones")
public class ImgSalonesController {

    @Autowired
    public ImagenesSalonesService imagenesSalonesService;

    @GetMapping("/listar")
    public ResponseEntity<List<ImagenesSalones>> listarImg() {
        return new ResponseEntity<>(imagenesSalonesService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ImagenesSalones> crearImg(@RequestBody ImagenesSalones img) {
        return new ResponseEntity<>(imagenesSalonesService.save(img), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ImagenesSalones> actualizarImg(@PathVariable Integer id, @RequestBody ImagenesSalones img) {
        ImagenesSalones imagen = imagenesSalonesService.findById(id);
        if (imagen != null) {
            try {

                imagen.setImgSalId(img.getImgSalId());
                imagen.setImgSalNombre(img.getImgSalNombre());
                imagen.setImgSalUrl(img.getImgSalUrl());
                imagen.setSalon(img.getSalon());

                return new ResponseEntity<>(imagenesSalonesService.save(imagen), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ImagenesSalones> elimiarPersona(@PathVariable Integer id) {
        imagenesSalonesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}