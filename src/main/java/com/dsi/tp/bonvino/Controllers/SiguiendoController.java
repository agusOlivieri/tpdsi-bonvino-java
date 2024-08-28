package com.dsi.tp.bonvino.Controllers;


import com.dsi.tp.bonvino.Models.Siguiendo;
import com.dsi.tp.bonvino.Repositories.SiguiendoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seguidores")
public class SiguiendoController {
    @Autowired
    private SiguiendoRepository siguiendoRepository;

    @GetMapping
    public List<Siguiendo> getAll() {
        return siguiendoRepository.findAll();
    }
}
