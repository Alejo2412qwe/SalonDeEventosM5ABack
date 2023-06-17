/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LaptopSA
 */
@Entity
@AllArgsConstructor
@Table(name = "Persona")
@NoArgsConstructor
public class Persona {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perId")
    private int perId;

    @Getter
    @Setter
    @Column(unique = true, name = "perCedula")
    private String perCedula;

    @Getter
    @Setter
    @Column(name = "perNombre")
    private String PerNombre;

    @Getter
    @Setter
    @Column(name = "perApellido")
    private String PerApellido;

    @Getter
    @Setter
    @Column(name = "perCorreo")
    private String PerCorreo;

    @Getter
    @Setter
    @Column(name = "perDireccion")
    private String PerDireccion;

    @Getter
    @Setter
    @Column(name = "perTelefono")
    private String PerTelefono;

    @Getter
    @Setter
    @Column(name = "perFechaNacimiento")
    private Date PerFechaNacimiento;

    @OneToOne(mappedBy = "UsuPerId")
    private Usuario usuario;
}
