package com.dsi.tp.bonvino.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
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

    public Varietal(String descripcion, int porcentajeComposicion, TipoUva tipoUva) {
        this.descripcion = descripcion;
        this.porcentajeComposicion = porcentajeComposicion;
        this.tipoUva = tipoUva;
    }

    public static Varietal newVarietal(String descripcion, int porcentajeComposicion, TipoUva tipoUva) {
        return new Varietal(descripcion, porcentajeComposicion, tipoUva);
    }
}
