package com.dsi.tp.bonvino.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enofilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;

    @Column(name = "imagen_perfil")
    private String imagenPerfil;

    @ManyToOne
    @JoinColumn(name = "siguiendo")
    private Siguiendo siguiendo;
    @OneToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "vino")
    private Vino vino;

    // metodos

    public String getNombreUsuario() {
        return this.usuario.getNombre();
    }

    public boolean seguisABodega(Bodega bodega) {
        return this.siguiendo.sosDeBodega(bodega);
    }
}