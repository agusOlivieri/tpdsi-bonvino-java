package com.dsi.tp.bonvino.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipo_uva")
public class TipoUva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private  String descripcion;

    // metodos

    public boolean esTipoUva(TipoUva tipoUva) {
        return this.equals(tipoUva);
    }
}
