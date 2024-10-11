package com.dsi.tp.bonvino.Services;

import com.dsi.tp.bonvino.Models.Maridaje;
import com.dsi.tp.bonvino.Repositories.MaridajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaridajeService {
    @Autowired
    private MaridajeRepository maridajeRepository;

    public List<Maridaje> getAll() { return maridajeRepository.findAll(); }
}
