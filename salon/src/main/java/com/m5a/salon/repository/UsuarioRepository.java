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

//    @Query(value = "SELECT rol_id, usu_id, usu_per_id, usu_fecha_registro, usu_contraseña, usu_nombre_usuario FROM usuario WHERE usu_nombre_usuario = :usuario;", nativeQuery = true)
    @Query(value = "SELECT * FROM usuario WHERE usu_nombre_usuario = :usuario;", nativeQuery = true)
    Usuario buscarNombre(@Param("usuario") String usuario);

    @Query(value = "SELECT rol_id, usu_id, usu_per_id, usu_fecha_registro, usu_contraseña, usu_nombre_usuario FROM usuario WHERE usu_nombre_usuario = :usuario AND usu_contraseña = :password", nativeQuery = true)
    public Usuario buscarUser(@Param("usuario") String usuario, @Param("password") String password);
}
