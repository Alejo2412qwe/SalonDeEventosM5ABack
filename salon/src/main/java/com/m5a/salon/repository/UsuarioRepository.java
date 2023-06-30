/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.salon.repository;

import com.m5a.salon.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author LaptopSA
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT COUNT(*) FROM usuario WHERE usu_nombre_usuario = :usuario", nativeQuery = true)
    int usuarioUnico(@Param("usuario") String usuario);

    @Query(value = "SELECT * FROM usuario WHERE usu_nombre_usuario = :usuario", nativeQuery = true)
    Usuario buscarUsuario(@Param("usuario") String usuario);

    @Query(value = "SELECT * FROM usuario WHERE usu_nombre_usuario = :usuario AND usu_contrasena = :password", nativeQuery = true)
    public Usuario login(@Param("usuario") String usuario, @Param("password") String password);
}
