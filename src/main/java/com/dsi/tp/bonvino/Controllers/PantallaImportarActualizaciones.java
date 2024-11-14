package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Models.Vino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Controller
public class PantallaImportarActualizaciones {

    private GestorImportarActualizaciones gestorImportarActualizaciones;

    public void setGestorImportarActualizaciones(GestorImportarActualizaciones gestorImportarActualizaciones) {
        this.gestorImportarActualizaciones = gestorImportarActualizaciones;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/actualizacion-bodegas") // <-- No me gusta el endpoint
    public String opImportarActualizacionVinos(Model model) {
        return gestorImportarActualizaciones.opImportarActualizacionVinos(model);
    }

    @GetMapping("/actualizar")
    public String tomarSeleccionBodega(@RequestParam String bodegaSeleccion, Model model) {
        return gestorImportarActualizaciones.tomarSeleccionBodega(bodegaSeleccion, model);
    }

    public String mostrarBodegasParaActualizar(List<String> bodegasParaActualizar, Model model) {

        model.addAttribute("bodegas", bodegasParaActualizar);
        return "actualizacion-bodegas";
    }


    public String mostrarResumenVinosImportados(List<Map<String, Object>> resumenVinosImportados, Model model) {
        model.addAttribute("vinos", resumenVinosImportados);
        return "vinos-importados";
    }
}
