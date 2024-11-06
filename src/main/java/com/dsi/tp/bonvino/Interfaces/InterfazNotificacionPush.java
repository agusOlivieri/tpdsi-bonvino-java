package com.dsi.tp.bonvino.Interfaces;

import java.util.List;

public class InterfazNotificacionPush implements IObservadorNotif{
    @Override
    public String notificarNovedadVinoParaBodega(String texto, List<String> seguidores) {
        for(String seguidor: seguidores) {
            notificarEnofilo(texto, seguidor);
        }

        return "Los seguidores de esta bodega fueron notificados de las novedades con exito!";
    }

    public boolean notificarEnofilo(String texto, String enofilo) { // <-- faltan parametros
        // Lógica para notificar a los enofilos
        return true;
    }

    public InterfazNotificacionPush() {
    }

}
