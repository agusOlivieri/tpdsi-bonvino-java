package com.dsi.tp.bonvino.Entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class VinoTest {

    @InjectMocks
    private Vino vino;

    @Mock
    private Maridaje maridajeMock;

    @Mock
    private Varietal varietalMock;

    @Mock
    private Bodega bodegaMock;

    @Mock
    private TipoUva tipoUvaMock;

    @BeforeEach
    public void setUp() {
        vino = new Vino();
        vino.setNombre("Vino Test");
        vino.setVintage(2020);
        vino.setPrecioARS(BigDecimal.valueOf(1000));  // BigDecimal para el precio
    }

    @Test
    public void testNewVino() {
        Vino nuevoVino = Vino.newVino(2020, "imagen.jpg", "Vino Test", BigDecimal.valueOf(1500),
                "Nota de Cata", maridajeMock, bodegaMock,
                "Varietal Desc", 50, tipoUvaMock);

        assertNotNull(nuevoVino);
        assertEquals("Vino Test", nuevoVino.getNombre());
        assertEquals(2020, nuevoVino.getVintage());
        assertEquals(BigDecimal.valueOf(1500), nuevoVino.getPrecioARS());
    }

    @Test
    public void testEsVinoParaActualizar() {
        assertTrue(vino.esVinoParaActualizar("Vino Test"));
        assertFalse(vino.esVinoParaActualizar("Otro Vino"));
    }

    @Test
    public void testSetPrecio() {
        BigDecimal nuevoPrecio = BigDecimal.valueOf(2000);
        vino.setPrecio(nuevoPrecio);
        assertEquals(nuevoPrecio, vino.getPrecioARS());
    }

    @Test
    public void testSetNotaCata() {
        vino.setNotaCata("Nueva Nota de Cata");
        assertEquals("Nueva Nota de Cata", vino.getNotaCata());
    }

    @Test
    public void testSetImagenEtiqueta() {
        vino.setImagenEtiqueta("nueva_imagen.jpg");
        assertEquals("nueva_imagen.jpg", vino.getImagenEtiqueta());
    }

    @Test
    public void testCrearVarietal() {
        Varietal nuevoVarietal = Vino.crearVarietal("Varietal Desc", 50, tipoUvaMock);
        assertNotNull(nuevoVarietal);
        assertEquals("Varietal Desc", nuevoVarietal.getDescripcion());
        assertEquals(50, nuevoVarietal.getPorcentajeComposicion());
        assertEquals(tipoUvaMock, nuevoVarietal.getTipoUva());
    }
}
