package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Models.Bodega;
import com.dsi.tp.bonvino.Services.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bodegas")
public class GestorImportarActualizaciones {
    @Autowired
    private BodegaService bodegaService;

//    @GetMapping
//    public List<Bodega> getAll() {
//        return bodegaService.getAll();
//    }

    public List<String> opImportarActualizacionVinos() {
        return buscarBodegasParaActualizar();
    }

    @GetMapping
    public List<String> buscarBodegasParaActualizar() {
        List<Bodega> bodegas = bodegaService.getAll();
        List<String> bodegasParaActualizar = new ArrayList<>();

        System.out.println(bodegas);
        for(Bodega bodega : bodegas) {
            if (bodega.estaParaActualizarVinos()) {
            bodegasParaActualizar.add(bodega.getNombre());
            }
        }
        return bodegasParaActualizar;
    }
}
