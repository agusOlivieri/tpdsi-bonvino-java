package com.dsi.tp.bonvino.Services;

import com.dsi.tp.bonvino.Models.Bodega;
import com.dsi.tp.bonvino.Repositories.BodegaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodegaService {
    @Autowired
    private BodegaRepository bodegaRepository;

    public List<Bodega> getAll() {
        return bodegaRepository.findAll();
    }
}
