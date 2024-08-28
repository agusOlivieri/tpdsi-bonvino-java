package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 255)
    private String historia;

    @Column(name = "periodo_actualizacion")
    private Integer periodoActualizacion;

    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;

}

