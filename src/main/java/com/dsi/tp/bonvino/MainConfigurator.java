package com.dsi.tp.bonvino;

import com.dsi.tp.bonvino.Controllers.GestorImportarActualizaciones;
import com.dsi.tp.bonvino.Controllers.PantallaImportarActualizaciones;
import com.dsi.tp.bonvino.Interfaces.InterfazApiBodega;
import com.dsi.tp.bonvino.Interfaces.InterfazNotificacionPush;
import com.dsi.tp.bonvino.Models.Bodega;
import com.dsi.tp.bonvino.Models.Enofilo;
import com.dsi.tp.bonvino.Models.Maridaje;
import com.dsi.tp.bonvino.Models.TipoUva;
import com.dsi.tp.bonvino.Services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainConfigurator {
    private final ApplicationContext context;

    @Autowired
    public MainConfigurator(ApplicationContext context) {
        this.context = context;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void setUpDependencies() {
        PantallaImportarActualizaciones pantalla = context.getBean(PantallaImportarActualizaciones.class);
        GestorImportarActualizaciones gestor = context.getBean(GestorImportarActualizaciones.class);

        List<Enofilo> enofilos = enofiloService.getAll();
        List<Bodega> bodegas = bodegaService.getAll();
        List<TipoUva> tipoUvas = tipoUvaService.getAll();
        List<Maridaje> maridajes = maridajeService.getAll();

        gestor.setPantallaImportarActualizaciones(pantalla);
        gestor.setBodegas(bodegas);
        gestor.setTipoUvas(tipoUvas);
        gestor.setMaridajes(maridajes);
        gestor.setEnofilos(enofilos);
        pantalla.setGestorImportarActualizaciones(gestor);
    }

    @Autowired
    private BodegaService bodegaService;

    @Autowired
    private TipoUvaService tipoUvaService;

    @Autowired
    private MaridajeService maridajeService;

    @Autowired
    private EnofiloService enofiloService;

}
