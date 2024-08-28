package com.dsi.tp.bonvino.Controllers;


import com.dsi.tp.bonvino.Models.TipoUva;
import com.dsi.tp.bonvino.Repositories.TipoUvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tiposuvas")
public class TipoUvaController {
    @Autowired
    private TipoUvaRepository tipoUvaRepository;

    @GetMapping
    public List<TipoUva> getAll() {
        return tipoUvaRepository.findAll();
    }
}
