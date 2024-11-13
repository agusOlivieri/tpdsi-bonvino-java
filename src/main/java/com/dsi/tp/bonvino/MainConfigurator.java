package com.dsi.tp.bonvino;

import com.dsi.tp.bonvino.Controllers.GestorImportarActualizaciones;
import com.dsi.tp.bonvino.Controllers.PantallaImportarActualizaciones;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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

        pantalla.setGestorImportarActualizaciones(gestor);
        gestor.setPantallaImportarActualizaciones(pantalla);
    }

}
