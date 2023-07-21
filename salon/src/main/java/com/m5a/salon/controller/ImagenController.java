/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.controller;

import com.m5a.salon.model.entity.ImagenReserva;
import com.m5a.salon.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LaptopSA
 */
@RestController
@RequestMapping("/imagen")
public class ImagenController {

    /* try {
            ImagenReserva imagen = new ImagenReserva();
            imagen.setDatosImagen(imagenBytes);
            imagenRepository.save(imagen);
            
            return ResponseEntity.ok("Imagen guardada con éxito");
          
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la imagen");
        }*/
    @Autowired
    private ImagenRepository imagenRepository;

    @PostMapping("/guardar-imagen")
    public ResponseEntity<String> guardarImagen(@RequestBody byte[] imagenBytes) {

        /* try {
            ImagenReserva imagen = new ImagenReserva();
            imagen.setDatosImagenReserva(imagenBytes);
            imagenRepository.save(imagen);

                    return ResponseEntity.ok(imagen.getIdImagenReserva());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la imagen");
        }*/
        try {
            ImagenReserva imagen = new ImagenReserva();
            imagen.setDatosImagenReserva(imagenBytes);
            imagenRepository.save(imagen);

            // Devolver el ID de la imagen en la respuesta como String
            String imageId = String.valueOf(imagen.getIdImagenReserva());

            return ResponseEntity.ok(imageId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la imagen");
        }
    }
}
