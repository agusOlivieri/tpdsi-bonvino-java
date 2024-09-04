package com.dsi.tp.bonvino.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;


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

    @OneToMany(mappedBy = "bodega", cascade = CascadeType.ALL)
    private List<Vino> vinos;

    // Metodos

    public boolean estaParaActualizarVinos() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        if (this.ultimaActualizacion == null) {
            // Si nunca se ha actualizado, se puede actualizar de inmediato
            return true;
        }

        // Calcular la próxima fecha de actualización sumando los meses del periodo de actualización a la última actualización
        ZonedDateTime proximaActualizacion = this.ultimaActualizacion.atZone(ZoneId.of("UTC"))
                .plusMonths(this.periodoActualizacion);

        // Comparar la próxima fecha de actualización con la fecha actual
        return now.isAfter(proximaActualizacion) || now.isEqual(proximaActualizacion);
    }

    public Vino esVinoParaActualizar(String nom) {
        List<Vino> vinosDeBodega = this.getVinos();

        for (Vino vino : vinosDeBodega) {
            if (vino.esVinoParaActualizar(nom)) {
                return vino;
            }
        }

        return null;
    }

    public void actualizarUltimaFecha() {
        this.ultimaActualizacion = LocalDateTime.now(ZoneId.of("UTC"));
    }

    public Vino actualizarDatosVino(Vino vino, String imagen, String notaDeCata, BigDecimal precio) {
        vino.setPrecio(precio);
        vino.setNotaCata(notaDeCata);
        vino.setImagenEtiqueta(imagen);

        return vino;
    }

    public Vino crearVino(String nom, int vintage, String imagen, String notaDeCata, BigDecimal precio,
                          Maridaje maridaje, String descVarietal, int porcentajeComp, TipoUva tipoUva) {

        return new Vino(vintage, imagen, nom, precio, notaDeCata, maridaje, this, descVarietal, porcentajeComp, tipoUva);
    }
}

