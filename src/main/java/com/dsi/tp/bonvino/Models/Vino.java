package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    @Column(name = "añada")
    private String vintage;
    @Column(name = "imagen_etiqueta")
    private String imagenEtiqueta;
    @Column(name = "nota_cata")
    private String notaDeCata;
    @Column(name = "precio_ars")
    private double precioARS;

    @OneToOne
    @JoinColumn(name = "maridaje")
    private Maridaje maridaje;

    @OneToOne
    @JoinColumn(name = "varietal")
    private Varietal varietal;

    @OneToOne
    @JoinColumn(name = "bodega")
    private Bodega bodega;

    @OneToOne(mappedBy = "vino", cascade = CascadeType.ALL)
    private Enofilo enofilo;

}
