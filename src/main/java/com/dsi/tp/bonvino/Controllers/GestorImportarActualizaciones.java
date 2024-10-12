package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Models.*;
import com.dsi.tp.bonvino.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GestorImportarActualizaciones {
    @Autowired
    private BodegaService bodegaService;

    @Autowired
    private TipoUvaService tipoUvaService;

    @Autowired
    private MaridajeService maridajeService;

    @Autowired
    private VarietalService varietalService;

    @Autowired
    private VinoService vinoService;

    public List<String> opImportarActualizacionVinos() {
        return buscarBodegasParaActualizar();
    }

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

    @GetMapping("/tipouva")
    public List<TipoUva> getAllTipoUva() {
        return tipoUvaService.getAll();
    }

    @GetMapping("/maridaje")
    public List<Maridaje> getAllMaridaje() {
        return maridajeService.getAll();
    }

    @GetMapping("/varietal")
    public List<Varietal> getAllVarietal() {
        return varietalService.getAll();
    }

    @GetMapping("/vino")
    public List<Vino> getAllVino() {
        return vinoService.getAll();
    }
}
