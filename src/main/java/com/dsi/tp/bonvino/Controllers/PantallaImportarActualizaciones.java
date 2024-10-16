package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Services.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsi.tp.bonvino.Controllers.GestorImportarActualizaciones;

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

    @GetMapping("/actualizar/{nombreBodega}")
    public void tomarSeleccionBodega(@PathVariable String nombreBodega) {

    }

    public List<String> mostrarBodegasParaActualizar(List<String> bodegasParaActualizar) {
        return bodegasParaActualizar;
    }
}
