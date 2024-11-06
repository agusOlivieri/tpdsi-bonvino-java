package com.dsi.tp.bonvino.Interfaces;

import java.util.List;

public interface IObservadorNotif {
    String notificarNovedadVinoParaBodega(String texto, List<String> seguidores); // <-- corregir parametros (texto, usuarios seguidores, vinos (nombres) y bodega)
}
