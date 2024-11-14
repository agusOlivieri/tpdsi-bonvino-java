package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Excepciones.ActualizacionNoDisponibleException;
import com.dsi.tp.bonvino.Interfaces.IObservadorNotif;
import com.dsi.tp.bonvino.Interfaces.ISujeto;
import com.dsi.tp.bonvino.Interfaces.InterfazApiBodega;
import com.dsi.tp.bonvino.Interfaces.InterfazNotificacionPush;
import com.dsi.tp.bonvino.Models.*;
import com.dsi.tp.bonvino.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GestorImportarActualizaciones implements ISujeto {
    @Autowired
    private BodegaService bodegaService;

    @Autowired
    private VarietalService varietalService;

    @Autowired
    private VinoService vinoService;

    private final InterfazApiBodega interfazApiBodega;
    private final InterfazNotificacionPush interfazNotificacionPush;
    private PantallaImportarActualizaciones pantallaImportarActualizaciones;

    private List<Bodega> bodegas;
    private List<Maridaje> maridajes;
    private List<TipoUva> tipoUvas;
    private List<Enofilo> enofilos;

    public GestorImportarActualizaciones() {
        this.interfazApiBodega = new InterfazApiBodega();
        this.interfazNotificacionPush = new InterfazNotificacionPush();
    }

    public void setPantallaImportarActualizaciones(PantallaImportarActualizaciones pantallaImportarActualizaciones) {
        this.pantallaImportarActualizaciones = pantallaImportarActualizaciones;
    }

    public List<Bodega> getBodegas() {
        return bodegas;
    }

    public void setBodegas(List<Bodega> bodegas) {
        this.bodegas = bodegas;
    }

    public List<Maridaje> getMaridajes() {
        return maridajes;
    }

    public void setMaridajes(List<Maridaje> maridajes) {
        this.maridajes = maridajes;
    }

    public List<TipoUva> getTipoUvas() {
        return tipoUvas;
    }

    public void setTipoUvas(List<TipoUva> tipoUvas) {
        this.tipoUvas = tipoUvas;
    }

    public List<Enofilo> getEnofilos() {
        return enofilos;
    }

    public void setEnofilos(List<Enofilo> enofilos) {
        this.enofilos = enofilos;
    }

    public String opImportarActualizacionVinos(Model model) {
        List<String> bodegasParaActualizar = buscarBodegasParaActualizar();

        return pantallaImportarActualizaciones.mostrarBodegasParaActualizar(bodegasParaActualizar, model);
    }

    public List<String> buscarBodegasParaActualizar() {
        List<String> bodegasParaActualizar = new ArrayList<>();

        for(Bodega bodega : bodegas) {
            if (bodega.estaParaActualizarVinos()) {
                String nombreBodega = bodega.getNombre();
            bodegasParaActualizar.add(nombreBodega);
            }
        }
        return bodegasParaActualizar;
    }

    public String tomarSeleccionBodega(String bodegaSeleccion, Model model) {
        List<Object> actualizaciones = obtenerActualizacionVinosBodega(bodegaSeleccion);

        List<Map<String, Object>> resumenVinosImportados = actualizarOCrearVinos(bodegaSeleccion, actualizaciones); // <-- tiene que retornar una lista de Map<String, String>

        String mensaje = notificarUsuariosSeguidores(bodegaSeleccion); // <-- método de enganche

        return pantallaImportarActualizaciones.mostrarResumenVinosImportados(resumenVinosImportados, model); // <-- averiguar como retornar la lista de vinos y el mensaje de enofilos notificados
    }

    public List<Map<String, Object>> actualizarOCrearVinos(String bodegaSeleccion, List<Object> actualizaciones) {
        Bodega bod = bodegaService.getByNombre(bodegaSeleccion);
        List<Vino> vinosDeBodegaSeleccion = vinoService.getAllFromBodega(bod);
        List<Vino> vinosImportados = new ArrayList<>();
        List<Map<String, Object>> resumenVinosImportados = new ArrayList<>();

        for(Object actualizacion : actualizaciones) {
            if(actualizacion instanceof Map) {
                // mapeo de las actualizaciones
                Map<String, Object> actualizacionMap = (Map<String, Object>) actualizacion;

                // mapeo del atributo "varietal" en la lista de actualizaciones
                Map<String, Object> varietalMap = (Map<String, Object>) actualizacionMap.get("varietal");

                String nombreVinoParaActualizarCrear = (String) actualizacionMap.get("nombre");

                Vino vinoParaActualizar = bod.esVinoParaActualizar(vinosDeBodegaSeleccion, nombreVinoParaActualizarCrear);

                if(vinoParaActualizar != null) { // <-- actualizar vino
                    // recuperamos los datos para actualizar
                    int precioParaActualizar = (int) actualizacionMap.get("precioARS");
                    String notaParaActualizar = (String) actualizacionMap.get("notaDeCata");
                    String imagenParaActualizar = (String) actualizacionMap.get("imagenEtiqueta");

                    Vino vinoActualizado = bod.actualizarDatosVino(vinoParaActualizar, precioParaActualizar, imagenParaActualizar, notaParaActualizar);
                    vinoService.save(vinoActualizado);

                    vinosImportados.add(vinoActualizado);
                    System.out.println("Vino actualizado: " + vinoActualizado.getNombre());
                } else { // <-- crear vino
                    // recuperamos los datos de maridaje y tipoUva de las actualizaciones
                    int maridajeEnListaDeActualizaciones = (int) actualizacionMap.get("maridaje");
                    int tipouvaEnListaDeActualizaciones = (int) varietalMap.get("tipoUva");

                    // controlamos si existen el maridaje y tipo de uva en nuestra base de datos
                    Maridaje maridaje = buscarMaridaje(maridajeEnListaDeActualizaciones);
                    TipoUva tipoUva = buscarTipoUva(tipouvaEnListaDeActualizaciones);

                    if(maridaje != null && tipoUva != null) { // <-- si existen el maridaje y el tipo de uva, creamos el vino
                        // recuperamos los datos para crear el vino
                        int aniadaParaCrear = (int) actualizacionMap.get("aniada");
                        String imagenParaCrear = (String) actualizacionMap.get("imagenEtiqueta");
                        String notaParaCrear = (String) actualizacionMap.get("notaDeCata");
                        int precioParaCrear = (int) actualizacionMap.get("precioARS");
                        String descVarietalParaCrear = (String) varietalMap.get("descripcion");
                        int porcComposicionParaCrear = (int) varietalMap.get("porcentajeComposicion");

                        Vino vinoCreado = bod.crearVino(varietalService, nombreVinoParaActualizarCrear, aniadaParaCrear, imagenParaCrear, notaParaCrear, precioParaCrear, maridaje, descVarietalParaCrear, porcComposicionParaCrear, tipoUva);
                        vinoService.save(vinoCreado);

                        vinosImportados.add(vinoCreado);
                        System.out.println("Vino creado: " + vinoCreado.getNombre());
                    }
                }
            }
        }

        if(!vinosImportados.isEmpty()) { // Si se importaron vinos actualizamos la fecha de la bodega y creamos el resumen
            bod.actualizarUltimaFecha();
            bodegaService.save(bod);

            System.out.println("Fecha de última actualización actualizada.");

            for (Vino vino : vinosImportados) {
                Map<String, Object> vinoMap = new HashMap<>();
                vinoMap.put("nombre", vino.getNombre());
                vinoMap.put("aniada", vino.getAniada());
                vinoMap.put("precio", vino.getPrecioARS());
                vinoMap.put("imagenEtiqueta", vino.getImagenEtiqueta());

                resumenVinosImportados.add(vinoMap);
            }

        }

        return resumenVinosImportados;
    }

    public Maridaje buscarMaridaje(int mar) {
        for(Maridaje maridaje : maridajes) {
            if(maridaje.esMaridaje(mar)) {
                return maridaje;
            }
        }
        return null;
    }

    public TipoUva buscarTipoUva(int tipouva) {
        for(TipoUva tipo : tipoUvas) {
            if(tipo.esTipoUva(tipouva)) {
                return tipo;
            }
        }
        return null;
    }

    @GetMapping("/vinos")
    public List<Object> obtenerActualizacionVinosBodega(@RequestParam String bodegaSeleccion) {
        List<Object> actualizaciones = interfazApiBodega.obtenerActualizacionVinos(bodegaSeleccion);

        if (actualizaciones == null) {
            throw new ActualizacionNoDisponibleException("Error de conexión con servicio externo de bodegas");
        }

        return actualizaciones; // <-- implementar una validación en caso de que no retorne nada.
    }

    @Override
    public void suscribir(IObservadorNotif obs) {
        observadores.add(obs);
    }

    @Override
    public void quitar(IObservadorNotif obs) {
        observadores.remove(obs);
    }

    @Override
    public String notificar(String texto, List<String> seguidores) {
        String mensaje = interfazNotificacionPush.notificarNovedadVinoParaBodega(texto, seguidores);
        return mensaje;
    }

    public List<String> buscarSeguidoresBodega(String bodegaSeleccion) {
        List<String> usuariosSeguidores = new ArrayList<>();

        for(Enofilo enofilo : enofilos) {
            if (enofilo.seguisABodega(bodegaSeleccion)) {
                String nombreUsuarioSeguidor = enofilo.getNombreUsuario();
                usuariosSeguidores.add(nombreUsuarioSeguidor);
            }
        }
        return usuariosSeguidores;
    }

    public String notificarUsuariosSeguidores(String bodegaSeleccion) { // <-- implementación del patrón observer
        List<String> seguidores = buscarSeguidoresBodega(bodegaSeleccion);
        List<IObservadorNotif> interfaces = new ArrayList<>();
        String texto = "Últimas novedades de vinos en esta bodega!!";

        // creamos la interfaz de notificacion push
        InterfazNotificacionPush interfazNotificacionPush = new InterfazNotificacionPush();

        // agregamos a la lista de interfaces para suscribir
        interfaces.add(interfazNotificacionPush);

        // suscribimos las interfaces creadas
        for(IObservadorNotif obs : interfaces) {
            suscribir(obs);
        }

        // notificamos
        String mensaje = notificar(texto, seguidores);
        return mensaje;
    }

    @ExceptionHandler(ActualizacionNoDisponibleException.class)
    public ResponseEntity<String> manejarExcepcion(ActualizacionNoDisponibleException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(ex.getMessage());
    }
}
