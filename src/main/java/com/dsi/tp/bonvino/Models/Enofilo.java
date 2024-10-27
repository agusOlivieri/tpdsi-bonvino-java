package com.dsi.tp.bonvino.Models;


import jakarta.persistence.*;

@Entity
public class Enofilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "imagen_perfil")
    private String imagenPerfil;

    @ManyToOne
    @JoinColumn(name = "siguiendo_id")
    private Siguiendo siguiendo;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Constructors
    public Enofilo() {
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public Siguiendo getSiguiendo() {
        return siguiendo;
    }

    public void setSiguiendo(Siguiendo siguiendo) {
        this.siguiendo = siguiendo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    // Métodos
    public String getNombreUsuario() {
        return this.usuario.getNombre();
    }

    public boolean seguisABodega(String bodega) {
        return this.siguiendo.sosDeBodega(bodega);
    }
}
