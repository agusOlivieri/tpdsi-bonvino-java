package com.dsi.tp.bonvino.Controllers;

import com.dsi.tp.bonvino.Entities.Vino;
import com.dsi.tp.bonvino.Repositories.VinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vinos")
public class VinoController {
    @Autowired
    private VinoRepository vinoRepository;

    @GetMapping
    public List<Vino> getAll() {
        return vinoRepository.findAll();
    }
}
