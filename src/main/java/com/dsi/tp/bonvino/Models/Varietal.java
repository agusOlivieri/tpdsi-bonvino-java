package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Varietal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    @Column(name = "porcentaje_composicion")
    private int porcentajeComposicion;

    @OneToOne
    @JoinColumn(name = "tipo_uva")
    private TipoUva tipoUva;
}
