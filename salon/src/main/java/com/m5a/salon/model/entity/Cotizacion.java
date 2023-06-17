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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LaptopSA
 */
@Entity
@AllArgsConstructor
@Table(name = "Cotizacion")
@NoArgsConstructor
public class Cotizacion {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cotiId")
    private int cotiId;

    @Getter
    @Setter
    @Column(name = "cotiTipoEvento")
    private String tipoevento;

    @Getter
    @Setter
    @Column(name = "cotiFechaEvento")
    private Date fechaevento;

    @Getter
    @Setter
    @Column(name = "cotiDescipcion")
    private String descripcion;

    @Getter
    @Setter
    @Column(name = "cotiEstado")
    private boolean estado;

    @Getter
    @Setter
    @Column(name = "cotiMonto")
    private double monto;

    @Getter
    @Setter
    @Column(name = "cotiFecha")
    private Date fecha;

    @Getter
    @Setter
    @Column(name = "cotiHoraFin")
    private Date horafin;

    @Getter
    @Setter
    @Column(name = "cotiHoraInicio")
    private Date horainicio;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "salonId", referencedColumnName = "salonId")
    private Salon salon;

    @JsonIgnore
    @OneToMany(mappedBy = "cotizacion")
    private List<Adicionales> listaAdicionales;

    @OneToOne(mappedBy = "reCotiId")
    private Reserva reserva;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "usuId", referencedColumnName = "usuId")
    private Usuario usuario;

}
