package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Models.Varietal;
import com.dsi.tp.bonvino.Repositories.VarietalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/varietales")
public class VarietalController {
    @Autowired
    private VarietalRepository varietalRepository;

    @GetMapping
    public List<Varietal> getAll() { return varietalRepository.findAll(); }
}
