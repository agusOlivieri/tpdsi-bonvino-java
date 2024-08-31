package com.dsi.tp.bonvino.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/home")
public class ControllerBasic {
    
    @GetMapping(path = {"/"})   
    public String index() {
        return "index";
    }

    @GetMapping(path = {"/actualizacion-bodegas"})
    public String actualizacionBodegas() {
        return "actualizacion-bodegas";
    }
}
