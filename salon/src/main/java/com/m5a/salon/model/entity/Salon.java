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
@Table(name = "Salon")
@NoArgsConstructor
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salonId")
    private int salonId;

    @Column(name = "salonNombre")
    private String nombre;

    @Column(name = "salonDireccion")
    private String direccion;

    @Column(name = "salonCapacidad")
    private int capacidad;

    @Column(name = "salonCostoHora")
    private double costoHora;

    @Column(name = "salonEstado")
    private boolean estado;

    @JsonIgnore
    @OneToMany(mappedBy = "salon")
    private List<Cotizacion> listaCotizaciones;

}
