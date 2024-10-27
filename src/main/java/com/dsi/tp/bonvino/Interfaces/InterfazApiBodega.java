package com.dsi.tp.bonvino.Interfaces;

import com.dsi.tp.bonvino.Models.Vino;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class InterfazApiBodega {

    // Método para obtener todas las actualizaciones de vinos
    public List<Object> obtenerActualizacionVinos(String bodegaSeleccion) {

        ObjectMapper mapper = new ObjectMapper();
        List<Object> data = null;

        String RUTA_ARCHIVO_JSON = "actualizaciones/actualizaciones" + bodegaSeleccion.replaceAll(" ", "") + ".json";


        try {
            // Leer el archivo JSON y mapearlo a una lista de objetos Vino
            File actualizaciones = new ClassPathResource(RUTA_ARCHIVO_JSON).getFile();
            data = mapper.readValue(actualizaciones, new TypeReference<List<Object>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
