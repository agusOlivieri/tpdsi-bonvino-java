package com.dsi.tp.bonvino.Services;

import com.dsi.tp.bonvino.Models.TipoUva;
import com.dsi.tp.bonvino.Repositories.TipoUvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TipoUvaService {
    @Autowired
    private TipoUvaRepository tipoUvaRepository;

    public List<TipoUva> getAll() { return tipoUvaRepository.findAll(); }
}
