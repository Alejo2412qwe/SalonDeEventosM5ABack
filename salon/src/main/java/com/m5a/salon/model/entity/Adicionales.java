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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author LaptopSA
 */
@Entity
@AllArgsConstructor
@Table(name = "Adicionales")
@NoArgsConstructor
@Data
public class Adicionales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdicional")
    private int idAdicional;

    @ManyToOne
    @JoinColumn(name = "cotiId", referencedColumnName = "cotiId")
    private Cotizacion cotizacion;

    @ManyToOne
    @JoinColumn(name = "idProductoServicio", referencedColumnName = "idProductoServicio")
    private ProductoServicio productoServicio;
}
