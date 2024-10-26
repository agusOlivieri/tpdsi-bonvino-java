package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Models.Vino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@RestController
public class PantallaImportarActualizaciones {
    @Autowired
    private GestorImportarActualizaciones gestorImportarActualizaciones;

    @GetMapping("/actualizarrr")
    public List<String> opImportarActualizacionVinos() {
        List<String> bodegasParaActualizar = gestorImportarActualizaciones.opImportarActualizacionVinos();

        return mostrarBodegasParaActualizar(bodegasParaActualizar);
    }

    @GetMapping("/actualizar")
    public List<Vino> tomarSeleccionBodega(@RequestParam String bodegaSeleccion) {
        List<Vino> resumenVinosActualizados = gestorImportarActualizaciones.tomarSeleccionBodega(bodegaSeleccion);

        return mostrarResumenVinosImportados(resumenVinosActualizados);
    }

    public List<String> mostrarBodegasParaActualizar(List<String> bodegasParaActualizar) {
        return bodegasParaActualizar;
    }

    public List<Vino> mostrarResumenVinosImportados(List<Vino> resumenVinosImportados) {
        return resumenVinosImportados;
    }
}
