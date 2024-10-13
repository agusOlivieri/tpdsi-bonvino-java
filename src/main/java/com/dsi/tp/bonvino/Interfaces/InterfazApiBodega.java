package com.dsi.tp.bonvino.Interfaces;

import com.dsi.tp.bonvino.Models.Vino;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class InterfazApiBodega {

    private static final String RUTA_ARCHIVO_JSON = "src/main/java/com/dsi/tp/bonvino/actualizaciones/actualizacionesBodega1.json";

    // Método para obtener todas las actualizaciones de vinos
    public List<Object> obtenerActualizacionVinos() {
        ObjectMapper mapper = new ObjectMapper();
        List<Object> data = null;

        try {
            // Leer el archivo JSON y mapearlo a una lista de objetos Vino
            data = mapper.readValue(new File(RUTA_ARCHIVO_JSON), new TypeReference<List<Object>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
