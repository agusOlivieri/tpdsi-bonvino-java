package com.dsi.tp.bonvino.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Enofilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;

    @Column(name = "imagen_perfil")
    private String imagenPerfil;

    @OneToOne
    @JoinColumn(name = "siguiendo")
    private Siguiendo siguiendo;

    @OneToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "vino")
    private Vino vino;
}