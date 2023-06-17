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
import jakarta.persistence.Table;
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
@Table(name = "ProductoServicio")
@NoArgsConstructor
public class ProductoServicio {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProductoServicio")
    private int idProductoServicio;

    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name = "precio")
    private double precio;

    @Getter
    @Setter
    @Column(name = "descripcion")
    private String descripcion;

    @Getter
    @Setter
    @Column(name = "estado")
    private int estado;

    @JsonIgnore
    @OneToMany(mappedBy = "productoServicio")
    private List<Adicionales> listaAdicionales;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "idTipo", referencedColumnName = "idTipo")
    private Tipo tipo;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "cateId", referencedColumnName = "cateId")
    private Categoria categoria;

}
