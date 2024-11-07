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
    @Autowired
    private GestorImportarActualizaciones gestorImportarActualizaciones;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/actualizacion-bodegas") // <-- No me gusta el endpoint
    public String opImportarActualizacionVinos(Model model) {
        List<String> bodegasParaActualizar = gestorImportarActualizaciones.opImportarActualizacionVinos();

        return mostrarBodegasParaActualizar(bodegasParaActualizar, model);
    }

    @GetMapping("/actualizar")
    public String tomarSeleccionBodega(@RequestParam String bodegaSeleccion, Model model) {
        List<Map<String, Object>> resumenVinosImportados = gestorImportarActualizaciones.tomarSeleccionBodega(bodegaSeleccion); // <-- tiene que retornar una lista de diccionarios (datos de vinos actualizados)

        return mostrarResumenVinosImportados(resumenVinosImportados, model);
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
