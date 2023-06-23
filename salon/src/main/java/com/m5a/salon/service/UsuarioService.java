/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.service;

import com.m5a.salon.genericService.GenericService;
import com.m5a.salon.genericService.GenericServiceImpl;
import com.m5a.salon.model.entity.Usuario;
import com.m5a.salon.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LaptopSA
 */
@Service
public class UsuarioService extends GenericServiceImpl<Usuario, Integer> implements GenericService<Usuario, Integer> {

    @Autowired
    public UsuarioRepository usuarioRepository;

    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        return usuarioRepository;
    }

    public Usuario LogIn(String usuario, String password) {
        return usuarioRepository.buscarUser(usuario, password);
    }

    public Usuario Username(String usuario) {
        return usuarioRepository.buscarNombre(usuario);
    }

    public boolean siExisteUsuario(String usuario) {

        int usuarios = usuarioRepository.siExisteUsuario(usuario);
        if (usuarios > 0) {
            return false;
        } else {
            return true;
        }
    }
}
