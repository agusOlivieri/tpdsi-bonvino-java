package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tipo_uva")
public class TipoUva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private  String descripcion;

    @OneToOne(mappedBy = "tipo_uva", cascade = CascadeType.ALL)
    private Varietal varietal;

}
