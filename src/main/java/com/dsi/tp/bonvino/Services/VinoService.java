package com.dsi.tp.bonvino.Services;

import com.dsi.tp.bonvino.Models.Bodega;
import com.dsi.tp.bonvino.Models.Vino;
import com.dsi.tp.bonvino.Repositories.VinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VinoService {
    @Autowired
    private VinoRepository vinoRepository;

    public List<Vino> getAll() { return vinoRepository.findAll(); }

    public List<Vino> getAllFromBodega(Bodega bodega) {
        return vinoRepository.findByBodega(bodega);
    }

    public Vino newVino(Vino nuevoVino) {
        return vinoRepository.save(nuevoVino);
    }
}
