package com.dsi.tp.bonvino.Entities;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class BodegaTest {

    @InjectMocks
    private Bodega bodega;

    @Mock
    private Vino vinoMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        bodega = new Bodega();
        bodega.setNombre("Bodega Test");
        bodega.setPeriodoActualizacion(6); // 6 meses
        bodega.setUltimaActualizacion(LocalDateTime.now(ZoneOffset.UTC).minusMonths(7));
    }

    @Test
    public void testEstaParaActualizarVinos() {
        boolean resultado = bodega.estaParaActualizarVinos();
        assertTrue(resultado, "Debería estar listo para actualizar los vinos ya que han pasado más de 6 meses desde la última actualización");
    }

    @Test
    public void testEsVinoParaActualizar() {
        // Configuración del mock para simular el comportamiento de los vinos asociados a la bodega
        when(vinoMock.esVinoParaActualizar("Vino Test")).thenReturn(true);

        List<Vino> vinos = Arrays.asList(vinoMock);
        bodega.setVinos(vinos);

        Vino vinoResultado = bodega.esVinoParaActualizar("Vino Test");
        assertNotNull(vinoResultado, "Debería encontrar un vino para actualizar con el nombre 'Vino Test'");
    }

    @Test
    public void testActualizarUltimaFecha() {
        bodega.actualizarUltimaFecha();

        // Verificamos que la fecha se haya actualizado correctamente a la fecha y hora actual
        assertTrue(bodega.getUltimaActualizacion().isAfter(LocalDateTime.now(ZoneOffset.UTC).minusMinutes(1)),
                "La última actualización debería estar muy cerca de la hora actual");
    }

    @Test
    public void testActualizarDatosVino() {
        // Simulación de actualización de datos del vino
        when(vinoMock.getPrecioARS()).thenReturn(BigDecimal.valueOf(1500));
        when(vinoMock.getNotaCata()).thenReturn("Nueva Nota de Cata");
        when(vinoMock.getImagenEtiqueta()).thenReturn("nueva-imagen.jpg");

        bodega.actualizarDatosVino(vinoMock, "nueva-imagen.jpg", "Nueva Nota de Cata", BigDecimal.valueOf(1500));

        verify(vinoMock).setPrecio(BigDecimal.valueOf(1500));
        verify(vinoMock).setNotaCata("Nueva Nota de Cata");
        verify(vinoMock).setImagenEtiqueta("nueva-imagen.jpg");
    }

    @Test
    public void testCrearVino() {
        // Simulación de creación de un nuevo vino
        Vino vino = bodega.crearVino("Nuevo Vino", 2024, "imagen.jpg", "Nota de Cata", BigDecimal.valueOf(2000), new Maridaje(), "Descripción Varietal", 60, new TipoUva());

        assertNotNull(vino, "El nuevo vino no debería ser nulo");
        assertEquals("Nuevo Vino", vino.getNombre());
    }
}
