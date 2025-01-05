package com.tech.concesionaria.controller;


import com.tech.concesionaria.domain.Automovil;
import com.tech.concesionaria.service.AutomovilService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/automovil")
public class AutomovilController {

    private final AutomovilService automovilService;


    @PostMapping
    public void createAutomovil(@RequestBody Automovil automovil){
        try{
            automovilService.createAutomovil(automovil);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{patente}")
    public void eliminarAutomovil(@PathVariable String patente){
        try{
            automovilService.eliminarAutomovil(patente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/masPesado")
    public Automovil heaviestCar() {
        return automovilService.heaviestCar();
    }

}
