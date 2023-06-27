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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LaptopSA
 */
@Entity
@AllArgsConstructor
@Table(name = "Tipo")
@NoArgsConstructor
public class Tipo {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipId")
    private int tipId;

    @Setter
    @Getter
    @Column(name = "tipNombre")
    private String tipNombre;

    @Setter
    @Getter
    @Column(name = "tipFechaRegistro")
    private Timestamp tipFechaRegistro;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo")
    private List<ProductoServicio> listaProductos;

}
