/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.controller;

import com.m5a.salon.model.entity.Salon;
import com.m5a.salon.service.SalonService;
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
@RequestMapping("/salon")
public class SalonController {

    @Autowired
    public SalonService salonService;

    @GetMapping("/listar")
    public ResponseEntity<List<Salon>> listarSalones() {
        return new ResponseEntity<>(salonService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Salon> crearSalon(@RequestBody Salon s) {
        return new ResponseEntity<>(salonService.save(s), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Salon> actualizarRol(@PathVariable Integer id, @RequestBody Salon s) {
        Salon salon = salonService.findById(id);
        if (salon != null) {
            try {
                salon.setCapacidad(s.getCapacidad());
                salon.setCostoHora(s.getCostoHora());
                salon.setDireccion(s.getDireccion());
                salon.setEstado(s.isEstado());
                salon.setListaCotizaciones(s.getListaCotizaciones());
                salon.setNombre(s.getNombre());
                return new ResponseEntity<>(salonService.save(salon), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Salon> elimiarRol(@PathVariable Integer id) {
        salonService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
