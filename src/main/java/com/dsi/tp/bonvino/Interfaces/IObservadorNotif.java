package com.dsi.tp.bonvino.Interfaces;

import java.util.List;

public interface IObservadorNotif {
    String notificarNovedadVinoParaBodega(String texto, List<String> seguidores);
}
