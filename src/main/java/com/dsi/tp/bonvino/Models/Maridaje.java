package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Maridaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;

    @OneToOne(mappedBy = "maridaje", cascade = CascadeType.ALL)
    private Vino vino;
}
