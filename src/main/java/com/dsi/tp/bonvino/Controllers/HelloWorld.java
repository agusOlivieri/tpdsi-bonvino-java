package com.dsi.tp.bonvino.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/bodegas")
    public String hello(){
        return "hello world";
    }
}
