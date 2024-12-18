package com.dsi.tp.bonvino.Services;

import com.dsi.tp.bonvino.Models.Varietal;
import com.dsi.tp.bonvino.Repositories.VarietalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarietalService {
    @Autowired
    private VarietalRepository varietalRepository;

    public List<Varietal> getAll() { return varietalRepository.findAll(); }

    @Transactional
    public void save(Varietal nuevoVarietal) {
        varietalRepository.save(nuevoVarietal);
    }
}
