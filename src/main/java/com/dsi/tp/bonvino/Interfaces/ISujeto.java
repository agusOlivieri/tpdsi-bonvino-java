package com.dsi.tp.bonvino.Interfaces;


import java.util.ArrayList;
import java.util.List;

public interface ISujeto {
    List<IObservadorNotif> observadores = new ArrayList<>();

    void suscribir(IObservadorNotif obs);

    void quitar(IObservadorNotif obs);

    String notificar(String texto, List<String> seguidores);

    List<String> buscarSeguidoresBodega(String bodegaSeleccion);

    String notificarUsuariosSeguidores(String bodegaSeleccion);
}
