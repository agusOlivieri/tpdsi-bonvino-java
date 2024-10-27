package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Models.Vino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Collection;

import java.util.List;

@Controller
public class PantallaImportarActualizaciones {
    @Autowired
    private GestorImportarActualizaciones gestorImportarActualizaciones;

    @GetMapping("/actualizacion-bodegas")
    public String opImportarActualizacionVinos(Model model) {
        List<String> bodegasParaActualizar = gestorImportarActualizaciones.opImportarActualizacionVinos();

        return mostrarBodegasParaActualizar(bodegasParaActualizar, model);
    }

    @GetMapping("/actualizar/{nombreBodega}")
    public Collection<Vino> tomarSeleccionBodega(@PathVariable String nombreBodega) {
        List<Vino> vinosImportados = gestorImportarActualizaciones.actualizarOCrearVinos(nombreBodega);
    @GetMapping("/actualizar")
    public List<Vino> tomarSeleccionBodega(@RequestParam String bodegaSeleccion) {
        List<Vino> resumenVinosActualizados = gestorImportarActualizaciones.tomarSeleccionBodega(bodegaSeleccion);

        return vinosImportados;
    }

    public String mostrarBodegasParaActualizar(List<String> bodegasParaActualizar, Model model) {

        model.addAttribute("bodegas", bodegasParaActualizar);
        return "actualizacion-bodegas";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    public List<Vino> mostrarResumenVinosImportados(List<Vino> resumenVinosImportados) {
        return resumenVinosImportados;
    }
}
