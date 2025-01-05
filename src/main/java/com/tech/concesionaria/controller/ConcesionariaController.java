package com.tech.concesionaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConcesionariaController {

    @GetMapping("/saludo")
    public String index(){
        return "Hola";
    }
}
