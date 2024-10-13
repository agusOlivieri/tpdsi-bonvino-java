package com.dsi.tp.bonvino.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import java.time.LocalDateTime;


@Entity
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "historia")
    private String historia;

    @Column(name = "periodo_actualizacion")
    private int periodoActualizacion;

    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;

    // Constructors
    public Bodega() {
    }

    public Bodega(Integer id) {
        this.id = id;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public int getPeriodoActualizacion() {
        return periodoActualizacion;
    }

    public void setPeriodoActualizacion(int periodoActualizacion) {
        this.periodoActualizacion = periodoActualizacion;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public boolean estaParaActualizarVinos() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        if (this.ultimaActualizacion == null) {
            // Si nunca se ha actualizado, se puede actualizar de inmediato
            return true;
        }

        // Calcular la próxima fecha de actualización sumando los meses del periodo de actualización a la última actualización
        ZonedDateTime proximaActualizacion = this.ultimaActualizacion.atZone(ZoneId.of("UTC"))
                .plusMonths(this.periodoActualizacion);

        // Comparar la próxima fecha de actualización con la fecha actual
        return now.isAfter(proximaActualizacion) || now.isEqual(proximaActualizacion);
    }

}

