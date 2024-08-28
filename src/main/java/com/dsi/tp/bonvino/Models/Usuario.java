package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Boolean premium;
    private String password;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Enofilo enofilo;

}
