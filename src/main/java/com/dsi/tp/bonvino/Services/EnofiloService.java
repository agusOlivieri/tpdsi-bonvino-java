package com.dsi.tp.bonvino.Services;


import com.dsi.tp.bonvino.Models.Enofilo;
import com.dsi.tp.bonvino.Repositories.EnofiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnofiloService {
    @Autowired
    private EnofiloRepository enofiloRepository;

    public List<Enofilo> getAll() { return enofiloRepository.findAll(); }
}
