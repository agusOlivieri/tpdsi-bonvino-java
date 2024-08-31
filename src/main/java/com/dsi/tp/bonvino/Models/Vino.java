package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "bodega")
    private Bodega bodega;
    @ManyToOne
    @JoinColumn(name = "maridaje")
    private Maridaje maridajes;
    @ManyToOne
    @JoinColumn(name = "varietal")
    private Varietal varietales;
}
