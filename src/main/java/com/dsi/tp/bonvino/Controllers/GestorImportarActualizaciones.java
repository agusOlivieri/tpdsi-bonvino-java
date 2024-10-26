package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Interfaces.InterfazApiBodega;
import com.dsi.tp.bonvino.Models.*;
import com.dsi.tp.bonvino.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private final InterfazApiBodega interfazApiBodega;

    public GestorImportarActualizaciones() {
        this.interfazApiBodega = new InterfazApiBodega();
    }

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

//    public List<Vino> tomarSeleccionBodega(String bodegaSeleccion) {
//
//
//
//    }

    public List<Vino> actualizarOCrearVinos(@RequestParam String bodegaSeleccion) {
        List<Object> actualizaciones = obtenerActualizacionVinosBodega();
        Bodega bod = bodegaService.getByNombre(bodegaSeleccion);
        List<Vino> vinosImportados = new ArrayList<>();

        for(Object actualizacion : actualizaciones) {
            if(actualizacion instanceof Map) {
                // mapeo de las actualizaciones
                Map<String, Object> actualizacionMap = (Map<String, Object>) actualizacion;

                // mapeo del atributo "varietal" en la lista de actualizaciones
                Map<String, Object> varietalMap = (Map<String, Object>) actualizacionMap.get("varietal");

                String nombreVinoParaActualizarCrear = (String) actualizacionMap.get("nombre");

                Vino vinoParaActualizar = bod.esVinoParaActualizar(vinoService, nombreVinoParaActualizarCrear);

                if(vinoParaActualizar != null) {
                    int precioParaActualizar = (int) actualizacionMap.get("precioARS");
                    String notaParaActualizar = (String) actualizacionMap.get("notaDeCata");
                    String imagenParaActualizar = (String) actualizacionMap.get("imagenEtiqueta");

                    Vino vinoActualizado = bod.actualizarDatosVino(vinoParaActualizar, precioParaActualizar, imagenParaActualizar, notaParaActualizar);
                    vinosImportados.add(vinoActualizado);
                    System.out.println("Vino actualizado: " + vinoActualizado.getNombre());
                } else {
                    // controlamos si existen el maridaje y tipo de uva en nuestra base de datos
                    int maridajeEnListaDeActualizaciones = (int) actualizacionMap.get("maridaje");
                    int tipouvaEnListaDeActualizaciones = (int) varietalMap.get("tipoUva");

                    Maridaje maridaje = buscarMaridaje(maridajeEnListaDeActualizaciones);
                    TipoUva tipoUva = buscarTipoUva(tipouvaEnListaDeActualizaciones);

                    if(maridaje != null && tipoUva != null) { // si existen el maridaje y el tipo de uva, creamos el vino
                        int aniadaParaCrear = (int) actualizacionMap.get("aniada");
                        String imagenParaCrear = (String) actualizacionMap.get("imagenEtiqueta");
                        String notaParaCrear = (String) actualizacionMap.get("notaDeCata");
                        int precioParaCrear = (int) actualizacionMap.get("precioARS");
                        String descVarietalParaCrear = (String) varietalMap.get("descripcion");
                        int porcComposicionParaCrear = (int) varietalMap.get("porcentajeComposicion");

                        Vino vinoCreado = bod.crearVino(nombreVinoParaActualizarCrear, aniadaParaCrear, imagenParaCrear, notaParaCrear, precioParaCrear, bod, maridaje, descVarietalParaCrear, porcComposicionParaCrear, tipoUva);
                        vinosImportados.add(vinoCreado);
                        System.out.println("Vino creado: " + vinoCreado.getNombre());

                    }
                }
            }
        }

        return vinosImportados;
    }

    public Maridaje buscarMaridaje(int mar) {
        List<Maridaje> maridajes = maridajeService.getAll();

        for(Maridaje maridaje : maridajes) {
            if(maridaje.esMaridaje(mar)) {
                return maridaje;
            }
        }
        return null;
    }

    public TipoUva buscarTipoUva(int tipouva) {
        List<TipoUva> tipouvas = tipoUvaService.getAll();

        for(TipoUva tipo : tipouvas) {
            if(tipo.esTipoUva(tipouva)) {
                return tipo;
            }
        }
        return null;
    }

    @GetMapping("/vinos")
    public List<Object> obtenerActualizacionVinosBodega() {
        return interfazApiBodega.obtenerActualizacionVinos();
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
