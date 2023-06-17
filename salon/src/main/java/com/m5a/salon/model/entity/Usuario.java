/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author LaptopSA
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "Usuario")
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuId")
    private int usuId;

    @Column(name = "usuNombreUsuario")
    private String usuario;

    @Column(name = "usuContraseña")
    private String contrasena;

    @Column(name = "usuFechaRegistro")
    private Date fecharegistro;

    @OneToOne
    @JoinColumn(name = "UsuPerId")
    private Persona UsuPerId;

    @ManyToOne
    @JoinColumn(name = "rolId", referencedColumnName = "rolId")
    private Rol rol;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Cotizacion> listaCotizaciones;
}
