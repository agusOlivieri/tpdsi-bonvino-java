package com.dsi.tp.bonvino.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Vino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    @Column(name = "añada")
    private int vintage;
    @Column(name = "imagen_etiqueta")
    private String imagenEtiqueta;
    @Column(name = "nota_cata")
    private String notaCata;
    @Column(name = "precio_ars")
    private BigDecimal precioARS;

    @ManyToOne
    @JoinColumn(name = "bodega")
    private Bodega bodega;
    @ManyToOne
    @JoinColumn(name = "maridaje")
    private Maridaje maridaje;
    @ManyToOne
    @JoinColumn(name = "varietal")
    private Varietal varietal;

    // Metodos
    public Vino() {}
    
    public Vino(int vintage, String imagen, String nombre, BigDecimal precio, String notaDeCata,
                Maridaje maridaje, Bodega bodega, String descVarietal, int porcentajeComp, TipoUva tipoUva) {

        this.vintage = vintage;
        this.imagenEtiqueta = imagen;
        this.nombre = nombre;
        this.precioARS = precio;
        this.notaCata = notaDeCata;
        this.maridaje = maridaje;
        this.bodega = bodega;
        this.varietal = Vino.crearVarietal(descVarietal, porcentajeComp, tipoUva);
    }

    public static Vino newVino(int vintage, String imagen, String nombre, BigDecimal precio, String notaDeCata,
                               Maridaje maridaje, Bodega bodega, String descVarietal, int porcentajeComp, TipoUva tipoUva) {
        return new Vino(vintage, imagen, nombre, precio, notaDeCata, maridaje, bodega, descVarietal, porcentajeComp, tipoUva);
    }

    public boolean esVinoParaActualizar(String nombre) {
        return this.nombre.equals(nombre);
    }

    public void setPrecio(BigDecimal precio) {
        this.precioARS = precio;
    }

    public void setNotaCata(String nota) {
        this.notaCata = nota;
    }

    public void setImagenEtiqueta(String imagen) {
        this.imagenEtiqueta = imagen;
    }

    public static Varietal crearVarietal(String descVarietal, int porcentajeComp, TipoUva tipoUva) {
        return Varietal.newVarietal(descVarietal, porcentajeComp, tipoUva);
    }
}
