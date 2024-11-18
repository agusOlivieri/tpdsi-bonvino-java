package com.dsi.tp.bonvino.Interfaces;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterfazNotificacionPush implements IObservadorNotif{
    @Override
    public String notificarNovedadVinoParaBodega(List<String> seguidores, List<Map<String, Object>> resumenVinos, String bodega) {
        String mensajeNotificacion = crearMensajeNotificacion(bodega, resumenVinos);
        for(String seguidor: seguidores) {
            notificarEnofilo(seguidor, resumenVinos, bodega);
        }

        return mensajeNotificacion;
    }

    public boolean notificarEnofilo(String enofilo, List<Map<String, Object>> resumenVinos, String bodega) { // <-- faltan parametros
        // Lógica para notificar a los enofilos
        return true;
    }

    public InterfazNotificacionPush() {
    }

    public String crearMensajeNotificacion(String bodega, List<Map<String, Object>> vinosImportados) {
        StringBuilder mensaje = new StringBuilder();

        // Ajustar el nombre de la bodega si contiene "bodega"
        String nombreBodega = bodega.toLowerCase().contains("bodega")
                ? bodega.replaceFirst("(?i)bodega\\s*", "") // Elimina "Bodega" al principio
                : bodega;

        mensaje.append("Hay novedades sobre la bodega <strong>").append(nombreBodega).append("</strong>!!<br><br>");
        mensaje.append("<strong>Vinos importados: </strong>");

        // Generar la lista de vinos separados por comas
        String vinos = vinosImportados.stream()
                .map(vino -> (String) vino.get("nombre"))
                .collect(Collectors.joining(", "));
        mensaje.append(vinos);
        mensaje.append(".");

        return mensaje.toString();
    }

}
