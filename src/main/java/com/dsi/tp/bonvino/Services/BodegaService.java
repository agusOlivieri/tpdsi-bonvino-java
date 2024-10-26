package com.dsi.tp.bonvino.Services;

import com.dsi.tp.bonvino.Models.Bodega;
import com.dsi.tp.bonvino.Repositories.BodegaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodegaService {
    @Autowired
    private BodegaRepository bodegaRepository;

    public List<Bodega> getAll() {
        return bodegaRepository.findAll();
    }

    public Bodega getByNombre(String nombre) {
        Optional<Bodega> bodega = bodegaRepository.findByNombre(nombre);
        return bodega.orElse(null);
    }

    public void actualizarFecha(Bodega bodega) {
        bodegaRepository.save(bodega);
    }
}
