package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;

@Entity
public class Varietal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "porcentaje_composicion")
    private int porcentajeComposicion;

    @OneToOne
    @JoinColumn(name = "tipouva_id")
    private TipoUva tipoUva;

    public Varietal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoUva getTipoUva() {
        return tipoUva;
    }

    public void setTipoUva(TipoUva tipoUva) {
        this.tipoUva = tipoUva;
    }

    public int getPorcentajeComposicion() {
        return porcentajeComposicion;
    }

    public void setPorcentajeComposicion(int porcentajeComposicion) {
        this.porcentajeComposicion = porcentajeComposicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Varietal(String descripcion, int porcentajeComposicion, TipoUva tipoUva) {
        this.descripcion = descripcion;
        this.porcentajeComposicion = porcentajeComposicion;
        this.tipoUva = tipoUva;
    }

    public static Varietal newVarietal(String descripcion, int porcentajeComposicion, TipoUva tipoUva) {
        return new Varietal(descripcion, porcentajeComposicion, tipoUva);
    }
}

