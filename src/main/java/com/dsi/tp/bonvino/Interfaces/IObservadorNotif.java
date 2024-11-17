package com.dsi.tp.bonvino.Interfaces;

import java.util.List;
import java.util.Map;

public interface IObservadorNotif {
    String notificarNovedadVinoParaBodega(List<String> seguidores, List<Map<String, Object>> resumenVinos, String bodega); // <-- corregir parametros (texto, usuarios seguidores, vinos (nombres) y bodega)
}
