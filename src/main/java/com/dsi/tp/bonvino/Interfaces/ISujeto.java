package com.dsi.tp.bonvino.Interfaces;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ISujeto {
    List<IObservadorNotif> observadores = new ArrayList<>();

    void suscribir(IObservadorNotif obs);

    void quitar(IObservadorNotif obs);

    String notificar(List<String> seguidores, List<Map<String, Object>> resumenVinos, String bodega);

}
