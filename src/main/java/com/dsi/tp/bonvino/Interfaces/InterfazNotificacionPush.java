package com.dsi.tp.bonvino.Interfaces;

import java.util.List;
import java.util.Map;

public class InterfazNotificacionPush implements IObservadorNotif{
    @Override
    public String notificarNovedadVinoParaBodega(String texto, List<String> seguidores, List<Map<String, Object>> resumenVinos, String bodega) {
        for(String seguidor: seguidores) {
            notificarEnofilo(texto, seguidor, resumenVinos, bodega);
        }

        return "Los seguidores de la bodega " + bodega.replace("Bodega", "") + " fueron notificados de las novedades con exito!";
    }

    public boolean notificarEnofilo(String texto, String enofilo, List<Map<String, Object>> resumenVinos, String bodega) { // <-- faltan parametros
        // Lógica para notificar a los enofilos
        return true;
    }

    public InterfazNotificacionPush() {
    }

}
