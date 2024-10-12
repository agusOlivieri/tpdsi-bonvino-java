package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;

@Entity
public class Vino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "añada")
    private int aniada;

    @Column(name = "imagen_etiqueta")
    private String imagenEtiqueta;

    @Column(name = "nota_de_cata_bodega")
    private String notaDeCata;

    @Column(name = "precio_ars")
    private int precioARS;

    @ManyToOne
    @JoinColumn(name = "bodega_id")
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "maridaje_id")
    private Maridaje maridaje;

    @ManyToOne
    @JoinColumn(name = "varietal_id")
    private Varietal varietal;

    public Vino() {
    }

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

    public int getAniada() {
        return aniada;
    }

    public void setAniada(int aniada) {
        this.aniada = aniada;
    }

    public String getImagenEtiqueta() {
        return imagenEtiqueta;
    }

    public void setImagenEtiqueta(String imagenEtiqueta) {
        this.imagenEtiqueta = imagenEtiqueta;
    }

    public String getNotaDeCata() {
        return notaDeCata;
    }

    public void setNotaDeCata(String notaDeCata) {
        this.notaDeCata = notaDeCata;
    }

    public int getPrecioARS() {
        return precioARS;
    }

    public void setPrecioARS(int precioARS) {
        this.precioARS = precioARS;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Maridaje getMaridaje() {
        return maridaje;
    }

    public void setMaridaje(Maridaje maridaje) {
        this.maridaje = maridaje;
    }

    public Varietal getVarietal() {
        return varietal;
    }

    public void setVarietal(Varietal varietal) {
        this.varietal = varietal;
    }

    public Vino(int vintage, String imagen, String nombre, int precio, String notaDeCata,
                Maridaje maridaje, Bodega bodega, String descVarietal, int porcentajeComp, TipoUva tipoUva) {

        this.aniada = vintage;
        this.imagenEtiqueta = imagen;
        this.nombre = nombre;
        this.precioARS = precio;
        this.notaDeCata = notaDeCata;
        this.maridaje = maridaje;
        this.bodega = bodega;
        this.varietal = Vino.crearVarietal(descVarietal, porcentajeComp, tipoUva);
    }

    public static Varietal crearVarietal(String descVarietal, int porcentajeComp, TipoUva tipoUva) {
        return Varietal.newVarietal(descVarietal, porcentajeComp, tipoUva);
    }

    public static Vino newVino(int vintage, String imagen, String nombre, int precio, String notaDeCata,
                               Maridaje maridaje, Bodega bodega, String descVarietal, int porcentajeComp, TipoUva tipoUva) {
        return new Vino(vintage, imagen, nombre, precio, notaDeCata, maridaje, bodega, descVarietal, porcentajeComp, tipoUva);
    }

    public boolean esVinoParaActualizar(String nombre) {
        return this.nombre.equals(nombre);
    }
}
