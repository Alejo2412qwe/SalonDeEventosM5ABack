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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
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
@Table(name = "Empresa")
@NoArgsConstructor
public class Empresa {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId")
    private int empId;

    @Setter
    @Getter
    @Column(name = "empNombre")
    private String empNombre;

    @Setter
    @Getter
    @Column(name = "empTelefono")
    private String empTelefono;

    @Setter
    @Getter
    @Column(name = "empEmail")
    private String empEmail;

    @Setter
    @Getter
    @Column(name = "empFechaRegistro")
    private Timestamp empFechaRegistro;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Salon> listaSalones;

}