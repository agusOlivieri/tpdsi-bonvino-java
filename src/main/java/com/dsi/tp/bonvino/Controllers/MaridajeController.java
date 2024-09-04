package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Entities.Maridaje;
import com.dsi.tp.bonvino.Repositories.MaridajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maridajes")
public class MaridajeController {
    @Autowired
    private MaridajeRepository maridajeRepository;

    @GetMapping
    public List<Maridaje> getAll() {
        return maridajeRepository.findAll();
    }
}
