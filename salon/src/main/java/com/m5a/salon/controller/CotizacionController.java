/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.controller;

import com.m5a.salon.model.entity.Cotizacion;
import com.m5a.salon.service.CotizacionService;
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
@RequestMapping("/cotizacion")
public class CotizacionController {

    @Autowired
    public CotizacionService cotizacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cotizacion>> listarCotizaciones() {
        return new ResponseEntity<>(cotizacionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cotizacion> crearCotizaciones(@RequestBody Cotizacion c) {
        return new ResponseEntity<>(cotizacionService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cotizacion> actualizarCotizaciones(@PathVariable Integer id, @RequestBody Cotizacion c) {
        Cotizacion cotizacion = cotizacionService.findById(id);
        if (cotizacion != null) {
            try {
                cotizacion.setDescripcion(c.getDescripcion());
                cotizacion.setEstado(c.isEstado());
                cotizacion.setFecha(c.getFecha());
                cotizacion.setFechaevento(c.getFechaevento());
                cotizacion.setHorafin(c.getHorafin());
                cotizacion.setHorainicio(c.getHorainicio());
                cotizacion.setMonto(c.getMonto());
                cotizacion.setSalon(c.getSalon());
                cotizacion.setTipoevento(c.getTipoevento());
                cotizacion.setUsuario(c.getUsuario());

                return new ResponseEntity<>(cotizacionService.save(cotizacion), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cotizacion> elimiarCotizaciones(@PathVariable Integer id) {
        cotizacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
