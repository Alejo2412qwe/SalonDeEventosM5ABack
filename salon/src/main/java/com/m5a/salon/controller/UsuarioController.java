/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.controller;

import com.m5a.salon.model.entity.Rol;
import com.m5a.salon.model.entity.Usuario;
import com.m5a.salon.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario u) {
        return new ResponseEntity<>(usuarioService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario u) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            try {

                usuario.setContrasena(u.getContrasena());
                usuario.setFecharegistro(u.getFecharegistro());
                usuario.setListaCotizaciones(u.getListaCotizaciones());
                usuario.setUsuario(u.getUsuario());
                usuario.setUsuPerId(u.getUsuPerId());
                usuario.setRol(u.getRol());
                return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Rol> elimiarUsuario(@PathVariable Integer id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
