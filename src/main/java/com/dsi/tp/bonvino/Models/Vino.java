package com.dsi.tp.bonvino.Models;

import com.dsi.tp.bonvino.Services.VarietalService;
import com.dsi.tp.bonvino.Services.VinoService;
import jakarta.persistence.*;

@Entity
@Table(name = "vino")
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

    // Constructors
    public Vino() {
    }

    public Vino(String nombre, int aniada, String imagenEtiqueta, String notaDeCata, int precioARS, Bodega bodega, Maridaje maridaje, Varietal varietal) {
        this.nombre = nombre;
        this.aniada = aniada;
        this.imagenEtiqueta = imagenEtiqueta;
        this.notaDeCata = notaDeCata;
        this.precioARS = precioARS;
        this.bodega = bodega;
        this.maridaje = maridaje;
        this.varietal = varietal;
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

    public static Varietal crearVarietal(VarietalService varietalService, String descVarietal, int porcentajeComp, TipoUva tipoUva) {
        return Varietal.newVarietal(varietalService, descVarietal, porcentajeComp, tipoUva);
    }

    public static Vino newVino(VarietalService varietalService, VinoService vinoService, String nom, int aniada, String imagen, String nota, int precio, Bodega bodega, Maridaje maridaje, String desc_varietal, int porc_composicion, TipoUva tipoUva) {
        // creamos el nuevo varietal
        Varietal varietalNuevo = crearVarietal(varietalService, desc_varietal, porc_composicion, tipoUva);

        // creamos el nuevo vino
        Vino nuevoVino = new Vino(nom, aniada, imagen, nota, precio, bodega, maridaje, varietalNuevo);

        // persistimos el vino en la BD
        vinoService.save(nuevoVino);

        return nuevoVino;
    }

    public boolean esVinoParaActualizar(String nombre) {
        return this.nombre.equals(nombre);
    }
}
