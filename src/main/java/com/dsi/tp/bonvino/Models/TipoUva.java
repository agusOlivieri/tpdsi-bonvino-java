package com.dsi.tp.bonvino.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "tipouva")
public class TipoUva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre", nullable=false)
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    // metodos

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

    public boolean esTipoUva(TipoUva tipoUva) {
        return this.equals(tipoUva);
    }
}
