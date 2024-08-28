package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Varietal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    @Column(name = "porcentaje_composicion")
    private int porcentajeComposicion;

    @OneToOne
    @JoinColumn(name = "tipo_uva")
    private TipoUva tipo_uva;

    @OneToOne(mappedBy = "varietal", cascade = CascadeType.ALL)
    private Vino vino;
}
