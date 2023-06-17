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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

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
@Table(name = "Reserva")
@NoArgsConstructor
public class Reserva{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reId")
    private int reId;

    @Column(name = "reEstado")
    private boolean estado;

    @Column(name = "reComprobante")
    private String comprobante;

    @OneToOne
    @JoinColumn(name = "reCotiId")
    private Cotizacion reCotiId;
}
