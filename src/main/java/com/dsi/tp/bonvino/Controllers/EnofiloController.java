package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Models.Enofilo;
import com.dsi.tp.bonvino.Repositories.EnofiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enofilos")
public class EnofiloController {
    @Autowired
    private EnofiloRepository enofiloRepository;

    @GetMapping
    public List<Enofilo> getAll() { return enofiloRepository.findAll(); }
}
