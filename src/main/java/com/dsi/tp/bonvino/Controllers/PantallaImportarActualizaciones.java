package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Services.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsi.tp.bonvino.Controllers.GestorImportarActualizaciones;

import java.util.List;

@RestController
@RequestMapping("/actualizar")
public class PantallaImportarActualizaciones {
    @Autowired
    private GestorImportarActualizaciones gestorImportarActualizaciones;

    @GetMapping
    public List<String> opImportarActualizacionVinos() {
        return gestorImportarActualizaciones.opImportarActualizacionVinos();
    }

//    public void tomarSeleccionBodega(String bodega) {
//
//    }

}
